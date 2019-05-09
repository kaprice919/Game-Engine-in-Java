package events;

import java.io.Serializable;

public enum Events implements Serializable {
    KEYPRESSED, KEYRELEASED, COLLISION, GRAVITY, SPAWN, DEATH, RECORD, REPLAY, PLAYERSHOOTEVENT, ENEMYSHOOTEVENT, WIN, LEFT
}
