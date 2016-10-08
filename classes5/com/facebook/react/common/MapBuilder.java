package com.facebook.react.common;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder
{
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder(null);
  }
  
  public static <K, V> HashMap<K, V> newHashMap()
  {
    return new HashMap();
  }
  
  public static <K, V> Map<K, V> of()
  {
    return newHashMap();
  }
  
  public static <K, V> Map<K, V> of(K paramK, V paramV)
  {
    Map localMap = of();
    localMap.put(paramK, paramV);
    return localMap;
  }
  
  public static <K, V> Map<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    Map localMap = of();
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    return localMap;
  }
  
  public static <K, V> Map<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    Map localMap = of();
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    return localMap;
  }
  
  public static <K, V> Map<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    Map localMap = of();
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    return localMap;
  }
  
  public static <K, V> Map<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    Map localMap = of();
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    return localMap;
  }
  
  public static <K, V> Map<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6)
  {
    Map localMap = of();
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    localMap.put(paramK6, paramV6);
    return localMap;
  }
  
  public static <K, V> Map<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6, K paramK7, V paramV7)
  {
    Map localMap = of();
    localMap.put(paramK1, paramV1);
    localMap.put(paramK2, paramV2);
    localMap.put(paramK3, paramV3);
    localMap.put(paramK4, paramV4);
    localMap.put(paramK5, paramV5);
    localMap.put(paramK6, paramV6);
    localMap.put(paramK7, paramV7);
    return localMap;
  }
  
  public static final class Builder<K, V>
  {
    private Map mMap = MapBuilder.newHashMap();
    private boolean mUnderConstruction = true;
    
    public Map<K, V> build()
    {
      if (!this.mUnderConstruction) {
        throw new IllegalStateException("Underlying map has already been built");
      }
      this.mUnderConstruction = false;
      return this.mMap;
    }
    
    public Builder<K, V> put(K paramK, V paramV)
    {
      if (!this.mUnderConstruction) {
        throw new IllegalStateException("Underlying map has already been built");
      }
      this.mMap.put(paramK, paramV);
      return this;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\common\MapBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */