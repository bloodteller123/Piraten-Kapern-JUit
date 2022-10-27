Feature: Handle multiple single player scoring scenarios

  Scenario: row 37 die with 3 skulls 5 swords on first roll and player gets a score of 0
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull skull skull saber saber saber saber saber"
    Then player 1 does skull check
    And player 1 gets 0 scores
    And player 1 dies
###
  Scenario: row 38 roll 1 skull, 4 parrots, 3 swords, reroll 3 swords, get 2 skulls 1 sword die
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull saber saber saber parrot parrot parrot parrot"
    And player 1 rerolls "saber" to get "saber skull skull"
    Then player 1 does skull check
    And player 1 gets 0 scores
    And player 1 dies
##
  Scenario: row 39 roll 2 skull, 4 parrots, 2 swords, reroll 2 swords, get 1 skulls 1 sword die
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull skull saber saber parrot parrot parrot parrot"
    And player 1 rerolls "saber" to get "saber skull"
    Then player 1 does skull check
    And player 1 gets 0 scores
    And player 1 dies
##
  Scenario: row 40 roll 1 skull, 4 parrots, 3 swords, reroll 3 swords, get 1 skull 2 monkeys, reroll
  2 monkeys, get 1 skull 1 monkey die
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull saber saber saber parrot parrot parrot parrot"
    And player 1 rerolls "saber" to get "monkey monkey skull"
    And player 1 rerolls "monkey" to get "monkey skull"
    Then player 1 does skull check
    And player 1 gets 0 scores
    And player 1 dies
##
  Scenario: row 42 roll 1 skull, 2 parrots, 3 swords, 2 coins, reroll 2 parrots, get 2 coins, reroll
  3 swords, get 3 coins and get 4800 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull saber saber saber parrot parrot coin coin"
    And player 1 rerolls "parrot" to get "coin coin"
    And player 1 rerolls "saber" to get "coin coin coin"
    Then player 1 does skull check
    And player 1 gets 4800 scores
##
  Scenario: row 44 roll 2 parrots, 2 diamonds, 2 coins, 2 monkeys and get 800 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "captain"
    And player 1 rolls "diamond diamond parrot parrot coin coin monkey monkey"
    Then player 1 does skull check
    And player 1 gets 800 scores
##
  Scenario: row 45 roll 2 parrots, 2 skulls, 2 sabers, 2 monkeys, reroll parrots, get 1 saber and
  1 monkey and get 300 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull skull saber saber parrot parrot monkey monkey"
    And player 1 rerolls "parrot" to get "saber monkey"
    Then player 1 does skull check
    And player 1 gets 300 scores
##
  Scenario: row 46 roll 3 monkeys 3 swords 2 skulls on first roll and player gets a score of 300
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull skull saber saber saber monkey monkey monkey"
    Then player 1 does skull check
    And player 1 gets 300 scores
#
  Scenario: row 47 roll 3 diamonds 1 swords 1 monkey 1 parrot 2 skulls on first roll and player gets a score of 500
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "diamond diamond diamond skull skull saber parrot monkey"
    Then player 1 does skull check
    And player 1 gets 500 scores
#
  Scenario: row 48 roll 4 coins 2 swords 2 skulls on first roll and player gets a score of 700
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "diamond"
    And player 1 rolls "skull skull saber saber coin coin coin coin"
    Then player 1 does skull check
    And player 1 gets 700 scores
#
  Scenario: row 49 roll 4 parrots 3 swords 1 skulls on first roll and player gets a score of 400
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "diamond"
    And player 1 rolls "skull saber saber saber parrot parrot parrot parrot"
    Then player 1 does skull check
    And player 1 gets 400 scores
#
  Scenario: row 50 roll 2 parrots, 2 coins 1 skulls, 3 sabers, reroll parrots, get 1 saber and
  1 coin and get 800 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull saber saber saber parrot parrot coin coin"
    And player 1 rerolls "parrot" to get "saber coin"
    Then player 1 does skull check
    And player 1 gets 800 scores
#
  Scenario: row 51 roll 2 parrots, 2 coins 1 skulls, 3 sabers, reroll parrots, get 1 saber and
  1 coin and get 1200 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "captain"
    And player 1 rolls "skull saber saber saber parrot parrot coin coin"
    And player 1 rerolls "parrot" to get "saber coin"
    Then player 1 does skull check
    And player 1 gets 1200 scores
#
  Scenario: row 52 roll 1 skull, 2 parrots, 2 monkeys 3 swords, reroll 2 monkeys, get 1 skull 1 sword, reroll
  2 parrots, get 1 sowrd 1 monkey and get 600 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull saber saber saber parrot parrot monkey monkey"
    And player 1 rerolls "monkey" to get "skull saber"
    And player 1 rerolls "parrot" to get "saber moneky"
    Then player 1 does skull check
    And player 1 gets 600 scores
#
  Scenario: row 54 roll 6 monkeys 2 skulls on first roll and player gets a score of 1100
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull skull monkey monkey monkey monkey monkey monkey"
    Then player 1 does skull check
    And player 1 gets 1100 scores
#
  Scenario: row 55 roll 7 parrots 1 skulls on first roll and player gets a score of 2100
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull parrot parrot parrot parrot parrot parrot parrot"
    Then player 1 does skull check
    And player 1 gets 2100 scores
#
  Scenario: row 56 roll 8 coins first roll and player gets a score of 5400
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "coin coin coin coin coin coin coin coin"
    Then player 1 does skull check
    And player 1 gets 5400 scores
#
  Scenario: row 57 roll 8 coins first roll and player gets a score of 5400
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "diamond"
    And player 1 rolls "coin coin coin coin coin coin coin coin"
    Then player 1 does skull check
    And player 1 gets 5400 scores

  Scenario: row 58 roll 8 swords first roll and player gets a score of 9000
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "captain"
    And player 1 rolls "saber saber saber saber saber saber saber saber"
    Then player 1 does skull check
    And player 1 gets 9000 scores
#
  Scenario: row 59 roll 6 monkeys, 2 sabers, reroll sabers, get 2 monkey and get 4600 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "saber saber monkey monkey monkey monkey monkey monkey"
    And player 1 rerolls "saber" to get "monkey monkey"
    Then player 1 does skull check
    And player 1 gets 4600 scores
#
  Scenario: row 60 roll 2 monkeys, 2 sabers 2 skulls 2 parrots, reroll parrots, get 2 diamonds and get 400 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "diamond"
    And player 1 rolls "skull skull saber saber parrot parrot monkey monkey"
    And player 1 rerolls "parrot" to get "diamond diamond"
    Then player 1 does skull check
    And player 1 gets 400 scores
#
  Scenario: row 61 roll 2 monkeys, 2 sabers 2 skulls 1 diamond 1 parrot, reroll monkeys, get 2 diamonds and get 500 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "diamond skull skull saber saber parrot monkey monkey"
    And player 1 rerolls "monkey" to get "diamond diamond"
    Then player 1 does skull check
    And player 1 gets 500 scores
#
  Scenario: row 62 roll 2 coins, 1 monkey 1 skulls 3 swords 1 parrot, reroll swords, get 1 coin
  1 monkey 1 parrot and get 600 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull saber saber saber parrot coin coin monkey"
    And player 1 rerolls "saber" to get "coin monkey parrot"
    Then player 1 does skull check
    And player 1 gets 600 scores
#
  Scenario: row 63 roll 2 coins, 1 monkey 1 skulls 3 swords 1 parrot, reroll swords, get 1 coin
  1 monkey 1 parrot and get 500 points
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "diamond"
    And player 1 rolls "skull saber saber saber parrot coin coin monkey"
    And player 1 rerolls "saber" to get "coin monkey parrot"
    Then player 1 does skull check
    And player 1 gets 500 scores
#
  Scenario: row 64 roll 4 monkeys 2 coins 2 skulls first roll and player gets a score of 600
    Given players are initialized
    And dice are initialized
    When player 1 has fortunate card "coin"
    And player 1 rolls "skull skull coin coin monkey monkey monkey monkey"
    Then player 1 does skull check
    And player 1 gets 600 scores