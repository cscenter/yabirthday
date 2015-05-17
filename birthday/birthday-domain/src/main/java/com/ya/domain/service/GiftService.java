package com.ya.domain.service;

import com.ya.domain.model.Gift;
import com.ya.domain.repository.GiftRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by olya on 12.05.15.
 */

@Service
@Transactional
public class GiftService {
    @Inject
    GiftRepository giftRepository;

    public List<Gift> listUserGifts(String login) {
        return giftRepository.findByOwnerLogin(login);
    }
}
