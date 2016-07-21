package edu.galileo.android.triviadeanemias.addcontact;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.triviadeanemias.addcontact.events.AddContactEvent;
import edu.galileo.android.triviadeanemias.addcontact.ui.AddContactView;
import edu.galileo.android.triviadeanemias.lib.EventBus;
import edu.galileo.android.triviadeanemias.lib.GreenRobotEventBus;


/**
 * Created by ihanaht on 12/06/2016.
 */
public class AddContactPresenterImpl implements AddContactPresenter {
    EventBus eventBus;
    AddContactView addContactView;
    AddContactInteractor addContactInteractor;

    public AddContactPresenterImpl(AddContactView addContactView) {
        this.eventBus = GreenRobotEventBus.getInstance();
        this.addContactView = addContactView;
        this.addContactInteractor = new AddContactInteractorImpl(new AddContactRepositoryImpl());
    }

    @Override
    public void onShow() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        addContactView = null;
        eventBus.unregister(this);
    }

    @Override
    public void addContact(String email) {
        addContactView.hideInput();
        addContactView.showProgress();
        this.addContactInteractor.addContact(email);
    }

    @Override
    @Subscribe
    public void onEventMainThread(AddContactEvent event) {
        if (addContactView != null){
            addContactView.hideProgress();
            addContactView.showInput();

            if (event.isError()){
                addContactView.contactNotAdded();
            }else {
                addContactView.contactAdded();
            }
        }
    }
}
