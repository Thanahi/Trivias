package edu.galileo.android.triviadeanemias.lib;

/**
 * Created by ihanaht on 11/06/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
