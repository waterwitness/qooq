package com.tencent.ttpic.model;

import java.util.List;

public class VideoMaterial
{
  private double blendAlpha;
  private int blendMode;
  private String dataPath;
  private List<DistortionItem> distortionItemList;
  private String faceExchangeImage;
  private List<FaceMoveItem> faceMoveItemList;
  private int[] faceMoveTriangles;
  private List<Integer> facePoints;
  private int faceoffType;
  private int featureType;
  private int grayScale;
  private boolean hasAudio;
  private String id;
  private String imageFacePointsFileName;
  private List<StickerItem> itemList;
  private boolean loadImageFromCache;
  private int maxFaceCount;
  private int minAppVersion;
  private int orderMode;
  private List<String> resourceList;
  private int shaderType;
  private boolean supportLandscape;
  private int triggerType;
  
  public double getBlendAlpha()
  {
    return this.blendAlpha;
  }
  
  public int getBlendMode()
  {
    return this.blendMode;
  }
  
  public String getDataPath()
  {
    return this.dataPath;
  }
  
  public List<DistortionItem> getDistortionItemList()
  {
    return this.distortionItemList;
  }
  
  public String getFaceExchangeImage()
  {
    return this.faceExchangeImage;
  }
  
  public List<FaceMoveItem> getFaceMoveItemList()
  {
    return this.faceMoveItemList;
  }
  
  public int[] getFaceMoveTriangles()
  {
    return this.faceMoveTriangles;
  }
  
  public List<Integer> getFacePoints()
  {
    return this.facePoints;
  }
  
  public int getFaceoffType()
  {
    return this.faceoffType;
  }
  
  public int getFeatureType()
  {
    return this.featureType;
  }
  
  public int getGrayScale()
  {
    return this.grayScale;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getImageFacePointsFileName()
  {
    return this.imageFacePointsFileName;
  }
  
  public List<StickerItem> getItemList()
  {
    return this.itemList;
  }
  
  public int getMaxFaceCount()
  {
    return this.maxFaceCount;
  }
  
  public int getMinAppVersion()
  {
    return this.minAppVersion;
  }
  
  public int getOrderMode()
  {
    return this.orderMode;
  }
  
  public List<String> getResourceList()
  {
    return this.resourceList;
  }
  
  public int getShaderType()
  {
    return this.shaderType;
  }
  
  public int getTriggerType()
  {
    return this.triggerType;
  }
  
  public boolean isHasAudio()
  {
    return this.hasAudio;
  }
  
  public boolean isLoadImageFromCache()
  {
    return this.loadImageFromCache;
  }
  
  public boolean isSupportLandscape()
  {
    return this.supportLandscape;
  }
  
  public void setBlendAlpha(double paramDouble)
  {
    this.blendAlpha = paramDouble;
  }
  
  public void setBlendMode(int paramInt)
  {
    this.blendMode = paramInt;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setDistortionItemList(List<DistortionItem> paramList)
  {
    this.distortionItemList = paramList;
  }
  
  public void setFaceExchangeImage(String paramString)
  {
    this.faceExchangeImage = paramString;
  }
  
  public void setFaceMoveItemList(List<FaceMoveItem> paramList)
  {
    this.faceMoveItemList = paramList;
  }
  
  public void setFaceMoveTriangles(int[] paramArrayOfInt)
  {
    this.faceMoveTriangles = paramArrayOfInt;
  }
  
  public void setFacePoints(List<Integer> paramList)
  {
    this.facePoints = paramList;
  }
  
  public void setFaceoffType(int paramInt)
  {
    this.faceoffType = paramInt;
  }
  
  public void setFeatureType(int paramInt)
  {
    this.featureType = paramInt;
  }
  
  public void setGrayScale(int paramInt)
  {
    this.grayScale = paramInt;
  }
  
  public void setHasAudio(boolean paramBoolean)
  {
    this.hasAudio = paramBoolean;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setImageFacePointsFileName(String paramString)
  {
    this.imageFacePointsFileName = paramString;
  }
  
  public void setItemList(List<StickerItem> paramList)
  {
    this.itemList = paramList;
  }
  
  public void setLoadImageFromCache(boolean paramBoolean)
  {
    this.loadImageFromCache = paramBoolean;
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    this.maxFaceCount = Math.max(1, paramInt);
  }
  
  public void setMinAppVersion(int paramInt)
  {
    this.minAppVersion = paramInt;
  }
  
  public void setOrderMode(int paramInt)
  {
    this.orderMode = paramInt;
  }
  
  public void setResourceList(List<String> paramList)
  {
    this.resourceList = paramList;
  }
  
  public void setShaderType(int paramInt)
  {
    this.shaderType = paramInt;
  }
  
  public void setSupportLandscape(boolean paramBoolean)
  {
    this.supportLandscape = paramBoolean;
  }
  
  public void setTriggerType(int paramInt)
  {
    this.triggerType = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\model\VideoMaterial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */