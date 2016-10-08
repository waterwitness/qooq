package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class VideoImageCache2
{
  private final Map<String, Bitmap> cache = new ConcurrentHashMap();
  private LoadListener listener;
  
  private void loadAllItems(List<StickerItem> paramList, String paramString1, String paramString2)
  {
    if (!VideoUtil.isEmpty(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)paramList.next();
        ArrayList localArrayList = new ArrayList(localStickerItem.frames);
        int i = 0;
        while (i < localStickerItem.frames)
        {
          localArrayList.add(localStickerItem.id + "_" + i + ".png");
          i += 1;
        }
        new LoadImageTask(this.cache, localArrayList, paramString1 + File.separator + localStickerItem.id, paramString2).execute(new Void[0]);
      }
    }
  }
  
  private void loadAllResources(List<String> paramList, String paramString)
  {
    if (!VideoUtil.isEmpty(paramList)) {
      new LoadImageTask(this.cache, paramList, paramString, null).execute(new Void[0]);
    }
  }
  
  public void clear()
  {
    Iterator localIterator = this.cache.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (VideoBitmapUtil.isLegal((Bitmap)localEntry.getValue())) {
        ((Bitmap)localEntry.getValue()).recycle();
      }
    }
    this.cache.clear();
  }
  
  public void loadAllImages(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null)
    {
      if (this.listener != null) {
        this.listener.onLoadFail();
      }
      return;
    }
    clear();
    loadAllResources(paramVideoMaterial.getResourceList(), paramVideoMaterial.getDataPath());
    loadAllItems(paramVideoMaterial.getItemList(), paramVideoMaterial.getDataPath(), VideoMaterialUtil.getMaterialId(paramVideoMaterial.getDataPath()));
  }
  
  public void loadAllImagesAppend(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null)
    {
      if (this.listener != null) {
        this.listener.onLoadFail();
      }
      return;
    }
    loadAllResources(paramVideoMaterial.getResourceList(), paramVideoMaterial.getDataPath());
    loadAllItems(paramVideoMaterial.getItemList(), paramVideoMaterial.getDataPath(), VideoMaterialUtil.getMaterialId(paramVideoMaterial.getDataPath()));
  }
  
  public Bitmap loadImage(String paramString)
  {
    return (Bitmap)this.cache.get(paramString);
  }
  
  public void setLoadListener(LoadListener paramLoadListener)
  {
    this.listener = paramLoadListener;
  }
  
  private static class LoadImageTask
    extends AsyncTask<Void, Integer, Boolean>
  {
    private Map<String, Bitmap> cache;
    private String dataPath;
    private final String materialId;
    private List<String> resourceList;
    
    public LoadImageTask(Map<String, Bitmap> paramMap, List<String> paramList, String paramString1, String paramString2)
    {
      this.cache = paramMap;
      this.resourceList = paramList;
      if (this.resourceList == null) {
        this.resourceList = new ArrayList();
      }
      this.dataPath = paramString1;
      this.materialId = paramString2;
    }
    
    protected Boolean doInBackground(Void... paramVarArgs)
    {
      if (this.cache == null) {
        return Boolean.valueOf(false);
      }
      Iterator localIterator = this.resourceList.iterator();
      label103:
      label185:
      label214:
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = this.dataPath + File.separator + str1;
        Object localObject = null;
        if (str2.startsWith("assets://"))
        {
          paramVarArgs = VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath(str2), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
          if (!TextUtils.isEmpty(this.materialId)) {
            break label185;
          }
        }
        for (;;)
        {
          if ((!VideoBitmapUtil.isLegal(paramVarArgs)) || (this.cache.containsKey(str1))) {
            break label214;
          }
          this.cache.put(str1, paramVarArgs);
          break;
          paramVarArgs = (Void[])localObject;
          if (!str2.startsWith("/")) {
            break label103;
          }
          paramVarArgs = (Void[])localObject;
          if (!VideoFileUtil.exists(str2)) {
            break label103;
          }
          paramVarArgs = VideoBitmapUtil.decodeSampledBitmapFromFile(str2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
          break label103;
          str1 = this.materialId + File.separator + str1;
        }
      }
      return Boolean.valueOf(true);
    }
  }
  
  public static abstract interface LoadListener
  {
    public abstract void onLoadFail();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\cache\VideoImageCache2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */