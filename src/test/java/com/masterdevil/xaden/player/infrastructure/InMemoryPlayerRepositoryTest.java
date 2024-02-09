package com.masterdevil.xaden.player.infrastructure;

import static com.masterdevil.xaden.domain.Unit.UNIT;
import static com.masterdevil.xaden.player.fixtures.PlayerFixture.APARK;
import static com.masterdevil.xaden.player.fixtures.PlayerFixture.MASTERDEVIL;
import static io.vavr.API.None;
import static io.vavr.API.Some;
import static org.assertj.core.api.Assertions.assertThat;

import com.masterdevil.xaden.domain.Unit;
import com.masterdevil.xaden.map.Direction;
import com.masterdevil.xaden.map.fixtures.MapFixture;
import com.masterdevil.xaden.player.Player;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InMemoryPlayerRepositoryTest {

  InMemoryPlayerRepository cut;

  @BeforeEach
  void beforeEach() {
    cut = new InMemoryPlayerRepository();
  }

  @Test
  void createAndUpdate() {
    Player player = MASTERDEVIL();

    // Create
    Either<Exception, Unit> save = cut.save(player);
    assertThat(save.isRight()).isTrue();
    assertThat(save.get()).isEqualTo(UNIT);

    // Get All
    Either<Exception, List<Player>> all = cut.getAll();
    assertThat(all.isRight()).isTrue();
    assertThat(all.get()).hasSize(1);

    // Update player coordinates
    player.navigateTo(Direction.EAST, MapFixture.MAP);
    Either<Exception, Unit> update = cut.save(player);
    assertThat(update.isRight()).isTrue();
    assertThat(update.get()).isEqualTo(UNIT);

    // Get All
    Either<Exception, List<Player>> allAfterUpdate = cut.getAll();
    assertThat(allAfterUpdate.isRight()).isTrue();
    assertThat(allAfterUpdate.get()).hasSize(1);
    assertThat(allAfterUpdate.get().head()).isEqualTo(player);
  }

  @Test
  void createMultiplePlayersAndSelectOne() {
    Player player1 = MASTERDEVIL();
    Player player2 = APARK();

    cut.save(player1);
    cut.save(player2);

    Either<Exception, List<Player>> all = cut.getAll();
    assertThat(all.isRight()).isTrue();
    assertThat(all.get()).hasSize(2);

    Either<Exception, Option<Player>> selectedPlayer = cut.getSelectedPlayer();
    assertThat(selectedPlayer.isRight()).isTrue();
    assertThat(selectedPlayer.get()).isEqualTo(None());

    cut.setSelectedPlayer(player1.getId());

    Either<Exception, Option<Player>> selectedPlayer2 = cut.getSelectedPlayer();
    assertThat(selectedPlayer2.isRight()).isTrue();
    assertThat(selectedPlayer2.get()).isEqualTo(Some(player1));
  }

}
