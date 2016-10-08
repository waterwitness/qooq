package com.tencent.ttpic.model;

import java.util.Arrays;

public class StickerItem
{
  public int[] alignFacePoints;
  public boolean alwaysTriggered;
  public int[] anchorPoint;
  public String audio;
  public int blendMode;
  public double frameDuration;
  public int frames;
  public int height;
  public String id;
  public String name;
  public int playCount;
  public double[] position;
  public int scaleFactor;
  public int[] scalePivots;
  public int triggerType;
  public int type;
  public int width;
  
  public String toString()
  {
    return "StickerItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", type=" + this.type + ", triggerType=" + this.triggerType + ", alwaysTriggered=" + this.alwaysTriggered + ", playCount=" + this.playCount + ", frameDuration=" + this.frameDuration + ", frames=" + this.frames + ", width=" + this.width + ", height=" + this.height + ", position=" + Arrays.toString(this.position) + ", audio='" + this.audio + '\'' + ", anchorPoint=" + Arrays.toString(this.anchorPoint) + ", alignFacePoints=" + Arrays.toString(this.alignFacePoints) + ", scalePivots=" + Arrays.toString(this.scalePivots) + ", scaleFactor=" + this.scaleFactor + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\model\StickerItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */