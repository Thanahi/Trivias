package edu.galileo.android.triviadeanemias.lib;

/**
 * Created by ihanaht on 14/07/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
