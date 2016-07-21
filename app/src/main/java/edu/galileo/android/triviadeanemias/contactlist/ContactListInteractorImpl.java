package edu.galileo.android.triviadeanemias.contactlist;

/**
 * Created by ihanaht on 12/06/2016.
 */
public class ContactListInteractorImpl implements ContactListInteractor {
    ContactListRepositoryImpl contactListRepository;

    public ContactListInteractorImpl() {
        this.contactListRepository = new ContactListRepositoryImpl();
    }

    @Override
    public void subscribeForContactEvents() {
        contactListRepository.subscribeForContactListUpdates();
    }

    @Override
    public void unsubscribeForContactEvents() {
        contactListRepository.unsubscribeForContactListUpdates();
    }

    @Override
    public void destroyContactListListener() {
        contactListRepository.destroyContactListListener();
    }

    @Override
    public void removeContact(String email) {
        contactListRepository.removeContact(email);
    }
}
