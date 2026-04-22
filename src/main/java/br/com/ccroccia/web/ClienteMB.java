package br.com.ccroccia.web;

import br.com.ccroccia.dao.ClientDAO;
import br.com.ccroccia.dao.IClientDao;
import br.com.ccroccia.domain.Client;
import br.com.ccroccia.service.ClientService;
import br.com.ccroccia.service.IClientService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Named("clienteMB")
@ViewScoped
public class ClienteMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Client client = new Client();
    private List<Client> clients = new ArrayList<>();

    private IClientDao clientDao;
    private IClientService clientService;

    @PostConstruct
    public void init() {
        this.clientDao = new ClientDAO();
        this.clientService = new ClientService(clientDao);
        load();
    }

    public void save() {
        try {
            clientService.save(client);
            addInfo("Cliente salvo com sucesso.");
            clear();
            load();
        } catch (Exception e) {
            addError("Erro ao salvar: " + e.getMessage());
        }
    }

    public void edit(Client c) {
        this.client = c;
        clientService.update(c);
    }

    public void delete(Client c) {
        clientService.delete(c.getCpf());
        addInfo("Cliente excluído.");
        load();
    }

    public void clear() {
        this.client = new Client();
    }

    private void load() {
        try {
            Collection<Client> all = clientDao.findAll();
            this.clients = (all == null) ? new ArrayList<>() : new ArrayList<>(all);
        } catch (Exception e) {
            addError("Erro ao carregar clientes: " + e.getMessage());
            this.clients = new ArrayList<>();
        }
    }

    private void addInfo(String msg) {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
    }

    private void addError(String msg) {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClients() {
        return clients;
    }
}
