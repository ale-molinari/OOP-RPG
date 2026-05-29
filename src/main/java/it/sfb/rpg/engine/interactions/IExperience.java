package it.sfb.rpg.engine.interactions;

public interface IExperience {
    int EXPERIENCE_THRESHOLD = 10;
    default int getExperienceThreshold() {
        return EXPERIENCE_THRESHOLD * getLevel();
    }

    int getCurrentExperience();
    void setCurrentExperience(int experience);
    int getLevel();
    void setLevel(int level);

    default void gainExperience(int experience) {
        int remainingToLvl = getExperienceThreshold() - getCurrentExperience();
        int remainingExp = remainingToLvl - experience;
        if(remainingExp > 0) {
            setCurrentExperience(getCurrentExperience() + experience);
            return;
        }
        levelUp();
        if(remainingExp < 0) gainExperience(-remainingExp);
    }

    default void levelUp() {
        setCurrentExperience(0);
        setLevel(getLevel() + 1);
    }

}
