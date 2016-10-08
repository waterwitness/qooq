package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.WriterCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface DiskStorage
{
  public abstract void clearAll()
    throws IOException;
  
  public abstract BinaryResource commit(String paramString, BinaryResource paramBinaryResource, Object paramObject)
    throws IOException;
  
  public abstract boolean contains(String paramString, Object paramObject)
    throws IOException;
  
  public abstract BinaryResource createTemporary(String paramString, Object paramObject)
    throws IOException;
  
  public abstract DiskDumpInfo getDumpInfo()
    throws IOException;
  
  public abstract Collection<Entry> getEntries()
    throws IOException;
  
  public abstract BinaryResource getResource(String paramString, Object paramObject)
    throws IOException;
  
  public abstract boolean isEnabled();
  
  public abstract void purgeUnexpectedResources();
  
  public abstract long remove(Entry paramEntry)
    throws IOException;
  
  public abstract long remove(String paramString)
    throws IOException;
  
  public abstract boolean touch(String paramString, Object paramObject)
    throws IOException;
  
  public abstract void updateResource(String paramString, BinaryResource paramBinaryResource, WriterCallback paramWriterCallback, Object paramObject)
    throws IOException;
  
  public static class DiskDumpInfo
  {
    public List<DiskStorage.DiskDumpInfoEntry> entries = new ArrayList();
    public Map<String, Integer> typeCounts = new HashMap();
  }
  
  public static class DiskDumpInfoEntry
  {
    public final String firstBits;
    public final String path;
    public final float size;
    public final String type;
    
    protected DiskDumpInfoEntry(String paramString1, String paramString2, float paramFloat, String paramString3)
    {
      this.path = paramString1;
      this.type = paramString2;
      this.size = paramFloat;
      this.firstBits = paramString3;
    }
  }
  
  public static abstract interface Entry
  {
    public abstract BinaryResource getResource();
    
    public abstract long getSize();
    
    public abstract long getTimestamp();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\disk\DiskStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */