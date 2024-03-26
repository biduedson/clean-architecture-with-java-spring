package br.com.curso.application.gateway;

import br.com.curso.core.domain.Transaction;

public interface UserNotificationGateway {
    boolean notificate(Transaction transaction, String email);
}
