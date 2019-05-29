/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author merciof
 */
public enum Action {
    ATTACK, CHARGE, BLOCK;
        
        private static final Map<Action, Action> winMap = new HashMap<>();
        
        static {
            winMap.put(ATTACK, CHARGE);
            winMap.put(CHARGE, BLOCK);
            winMap.put(BLOCK, ATTACK);
        }
        
        ActionResult checkAgainst(Action other) {
            if(this == other) {
                return ActionResult.DRAW;
            }
            
            return winMap.get(this) == other ? ActionResult.WIN : ActionResult.LOSE;
        }
}
