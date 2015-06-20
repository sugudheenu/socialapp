package com.sugudheenu.repository;

/**
 * Repository to store users Feed
 */
public interface UsersPostRepository {
    void post(String user, String message);
}
