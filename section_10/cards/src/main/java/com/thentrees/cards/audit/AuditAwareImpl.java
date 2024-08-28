package com.thentrees.cards.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/*
 * @author: Thentrees
 * @since: 28/07/2024 : 11:07
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor.
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("CARDS_MS");
    }
}
