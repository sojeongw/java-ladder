package ladderGame.step2.service;

import ladderGame.step2.model.Lines;
import ladderGame.step2.model.Players;

public class GamePlay {

  private final Players player;

  private final Lines lines;

  public GamePlay(final String stringNames, final int height) {
    this.player = new Players(Players.createUser(stringNames));
    this.lines = new Lines(height, this.player.count());
  }

  public Players getPlayer() {
    return player;
  }

  public Lines getLines() {
    return lines;
  }
}