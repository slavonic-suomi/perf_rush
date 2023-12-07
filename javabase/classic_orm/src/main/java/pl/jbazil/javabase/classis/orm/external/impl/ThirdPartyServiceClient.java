package pl.jbazil.javabase.classis.orm.external.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import pl.jbazil.javabase.classis.orm.external.ThirdPartyService;

import java.util.logging.Level;

@Log
@Component
@RequiredArgsConstructor
public class ThirdPartyServiceClient implements ThirdPartyService {

    @Value("${third_party.delay}")
    private final Long thirdPartyDelay;

    @Override
    public long execAndMeasure() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(thirdPartyDelay);
        } catch (InterruptedException e) {
            log.log(Level.WARNING, "Third party request interrupted", e);
            throw new RuntimeException(e.getMessage());
        }
        return System.currentTimeMillis() - start;
    }
}
