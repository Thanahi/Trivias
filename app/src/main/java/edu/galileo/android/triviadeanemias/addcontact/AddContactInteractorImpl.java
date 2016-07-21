package edu.galileo.android.triviadeanemias.addcontact;

/**
 * Created by ihanaht on 12/06/2016.
 */
public class AddContactInteractorImpl implements AddContactInteractor {
    AddContactRepositoryImpl addContactRepository;

    public AddContactInteractorImpl(AddContactRepositoryImpl addContactRepository) {
        this.addContactRepository = addContactRepository;
    }

    @Override
    public void addContact(String email) {
        addContactRepository.addContact(email);

    }
}
