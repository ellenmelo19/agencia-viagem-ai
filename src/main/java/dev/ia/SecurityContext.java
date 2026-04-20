package dev.ia;

public final class SecurityContext {
    private static final ThreadLocal<String> CURRENT_USER = new ThreadLocal<>();

    private SecurityContext() {
    }

    public static void setCurrentUser(String userName) {
        CURRENT_USER.set(userName);
    }

    public static String getCurrentUser() {
        return CURRENT_USER.get();
    }

    public static void clear() {
        CURRENT_USER.remove();
    }
}
