package edu.galileo.android.triviadeanemias.contactlist.ui.adpters;


import edu.galileo.android.triviadeanemias.entities.User;

/**
 * Created by ihanaht on 12/06/2016.
 */
public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}
