package com.example.oopkombat.Controller;

import com.example.oopkombat.DTO.CreateBuyHex;
import com.example.oopkombat.DTO.CreateBuyMinion;
import com.example.oopkombat.DTO.CreateEndTurn;
import com.example.oopkombat.Repository.InfoRepository;
import com.example.oopkombat.Repository.RunGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebsocketController {
    private final RunGameRepository runGameRepository;
    private final InfoRepository infoRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/buy-hex")
    public void buyHex(@Payload CreateBuyHex  createBuyHex) {
        simpMessagingTemplate.convertAndSend("/topic/all-hex", runGameRepository.buyHex(createBuyHex.getGameId(), createBuyHex.getPlayerId(), createBuyHex.getRow(), createBuyHex.getCol()));
        simpMessagingTemplate.convertAndSend("/topic/player-budget", infoRepository.getBudgetPlayer(createBuyHex.getGameId(), createBuyHex.getPlayerId()));
        simpMessagingTemplate.convertAndSend("/topic/current-turn", infoRepository.getCurrentTurn(createBuyHex.getGameId()));
    }

    @MessageMapping("/buy-minion")
    public void buyMinion(@Payload CreateBuyMinion createBuyMinion) {
        simpMessagingTemplate.convertAndSend("/topic/all-hex", runGameRepository.buyMinion(createBuyMinion.getGameId(), createBuyMinion.getMinionTypeId(), createBuyMinion.getPlayerId(), createBuyMinion.getRow(), createBuyMinion.getCol()));
        simpMessagingTemplate.convertAndSend("/topic/player-budget", infoRepository.getBudgetPlayer(createBuyMinion.getGameId(), createBuyMinion.getPlayerId()));
        simpMessagingTemplate.convertAndSend("/topic/current-turn", infoRepository.getCurrentTurn(createBuyMinion.getGameId()));
    }

    @MessageMapping("/end-turn")
    public void endTurn(@Payload CreateEndTurn createEndTurn) {
        if(createEndTurn.isEndTurn()){
            runGameRepository.endTurn(createEndTurn.getGameId(), createEndTurn.getPlayerId());
            simpMessagingTemplate.convertAndSend("/topic/current-turn", infoRepository.getCurrentTurn(createEndTurn.getGameId()));
        }
    }
}
