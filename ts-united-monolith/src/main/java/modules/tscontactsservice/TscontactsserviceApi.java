package modules.tscontactsservice;
import modules.tscontactsservice.contacts.controller.ContactsController;
import modules.tscontactsservice.contacts.entity.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TscontactsserviceApi {
    @Autowired
    ContactsController contactsController;

    public HttpEntity deleteApiV1ContactserviceContactsPathvariable(String contactsId, HttpHeaders headers) {
        return contactsController.deleteContacts(contactsId, headers);
    }

    public HttpEntity<?> postApiV1ContactserviceContactsAdmin(Contacts aci, HttpHeaders headers) {
        return contactsController.createNewContactsAdmin(aci, headers);
    }

    public HttpEntity putApiV1ContactserviceContacts(Contacts info, HttpHeaders headers) {
        return contactsController.modifyContacts(info, headers);
    }

    public HttpEntity getApiV1ContactserviceContactsPathvariable(String id, HttpHeaders headers) {
        return contactsController.getContactsByContactsId(id, headers);
    }

    public HttpEntity getApiV1ContactserviceContacts(HttpHeaders headers) {
        return contactsController.getAllContacts(headers);
    }
}