package com.example.mage_battle.inventory;

import com.example.mage_battle.R;
import android.widget.ImageView;


public class Rune {
    public enum RuneType {
        Fire, Earth, Water, Air
    }
    public RuneType runeType;
    public ImageView runeImage;
    public int imWidth, imHeight;

    public Rune(RuneType type){
        this.runeType = type;
        if (type == RuneType.Fire){
            this.runeImage.setImageResource(R.drawable.firerune);
        }
        if (type == RuneType.Air){
            this.runeImage.setImageResource(R.drawable.airrune);
        }
        if (type == RuneType.Earth){
            this.runeImage.setImageResource(R.drawable.earthrune);
        }
        if (type == RuneType.Water){
            this.runeImage.setImageResource(R.drawable.waterrune);
        }
    }

    public String ToString(){
        if (this.runeType == RuneType.Fire){
            return "Fire";
        }
        if (this.runeType == RuneType.Air){
            return "Air";
        }
        if (this.runeType == RuneType.Water){
            return "Water";
        }
        if (this.runeType == RuneType.Earth){
            return "Earth";
        }
        return "This should not happen";
    }
}
