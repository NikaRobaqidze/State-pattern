package ge.nick.utils;

/**
 * Functional interface to set lambda function to
 * call it at playing music.
 */

@FunctionalInterface
public interface PlayerCallBack {
    void callback();
}
