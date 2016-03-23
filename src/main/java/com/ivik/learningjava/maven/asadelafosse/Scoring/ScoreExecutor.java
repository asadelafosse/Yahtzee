package com.ivik.learningjava.maven.asadelafosse.Scoring;

/**
 * Created by Sebastien on 15-3-2016.
 */
public class ScoreExecutor {

    public static ScoreSheet[][] createScoreSheet() {
        ScoreSheet scoreAces = new SectionUpperAces();
        ScoreSheet scoreTwos = new SectionUpperTwos();
        ScoreSheet scoreThrees = new SectionUpperThrees();
        ScoreSheet scoreFours = new SectionUpperFours();
        ScoreSheet scoreFives = new SectionUpperFives();
        ScoreSheet scoreSixes = new SectionUpperSixes();
        ScoreSheet scoreUpperBonus = new BonusUpperSection();
        ScoreSheet upperHalf[] = {scoreAces, scoreTwos, scoreThrees, scoreFours, scoreFives, scoreSixes, scoreUpperBonus};

        ScoreSheet scoreThreeOfAKind = new SectionLowerThreeOfAKind();
        ScoreSheet scoreFourOfAKind = new SectionLowerFourOfAKind();
        ScoreSheet scoreFullHouse = new SectionLowerFullHouse();
        ScoreSheet scoreSmallStraight = new SectionLowerSmallStraight();
        ScoreSheet scoreLargeStraight = new SectionLowerLargeStraight();
        ScoreSheet scoreYahtzee = new SectionLowerYahtzee();
        ScoreSheet scoreChance = new SectionLowerChance();
        ScoreSheet[] lowerHalf = {scoreThreeOfAKind, scoreFourOfAKind, scoreFullHouse, scoreSmallStraight,
                scoreLargeStraight, scoreYahtzee, scoreChance};

        ScoreSheet scoreExtraYahtzeeBonus = new BonusExtraYahtzee();
        ScoreSheet[] bonusPoints = {scoreExtraYahtzeeBonus};

        return new ScoreSheet[][] {upperHalf, lowerHalf, bonusPoints};
    }

    /*public static void scoreQualifier(int[] roll){
        if (SectionLowerYahtzee.qualifies(roll)){
            BonusExtraYahtzee.processExtraYahtzee(roll);
            // call yahtzeebutton
        }

        if (SectionUpperAces.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionUpperTwos.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionUpperThrees.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionUpperFours.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionUpperFives.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionUpperSixes.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionLowerThreeOfAKind.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionLowerFourOfAKind.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionLowerFullHouse.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionLowerSmallStraight.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionLowerLargeStraight.qualifies(roll)){
            // call yahtzeebutton
        }

        if (SectionLowerChance.qualifies(roll)){
            // call yahtzeebutton
        }
    }*/
}
