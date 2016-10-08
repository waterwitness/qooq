package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CloseableAnimatedBitmap
  extends CloseableBitmap
{
  @GuardedBy("this")
  private List<CloseableReference<Bitmap>> mBitmapReferences;
  private volatile List<Bitmap> mBitmaps;
  private volatile List<Integer> mDurations;
  
  public CloseableAnimatedBitmap(List<CloseableReference<Bitmap>> paramList, List<Integer> paramList1)
  {
    Preconditions.checkNotNull(paramList);
    if (paramList.size() >= 1)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "Need at least 1 frame!");
      this.mBitmapReferences = new ArrayList();
      this.mBitmaps = new ArrayList();
      paramList = paramList.iterator();
      label61:
      if (paramList.hasNext()) {
        break label120;
      }
      this.mDurations = ((List)Preconditions.checkNotNull(paramList1));
      if (this.mDurations.size() != this.mBitmaps.size()) {
        break label164;
      }
    }
    label120:
    label164:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Arrays length mismatch!");
      return;
      bool1 = false;
      break;
      CloseableReference localCloseableReference = (CloseableReference)paramList.next();
      this.mBitmapReferences.add(localCloseableReference.clone());
      this.mBitmaps.add((Bitmap)localCloseableReference.get());
      break label61;
    }
  }
  
  public CloseableAnimatedBitmap(List<Bitmap> paramList, List<Integer> paramList1, ResourceReleaser<Bitmap> paramResourceReleaser)
  {
    Preconditions.checkNotNull(paramList);
    if (paramList.size() >= 1)
    {
      bool1 = true;
      Preconditions.checkState(bool1, "Need at least 1 frame!");
      this.mBitmaps = new ArrayList();
      this.mBitmapReferences = new ArrayList();
      paramList = paramList.iterator();
      label61:
      if (paramList.hasNext()) {
        break label120;
      }
      this.mDurations = ((List)Preconditions.checkNotNull(paramList1));
      if (this.mDurations.size() != this.mBitmaps.size()) {
        break label162;
      }
    }
    label120:
    label162:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Arrays length mismatch!");
      return;
      bool1 = false;
      break;
      Bitmap localBitmap = (Bitmap)paramList.next();
      this.mBitmapReferences.add(CloseableReference.of(localBitmap, paramResourceReleaser));
      this.mBitmaps.add(localBitmap);
      break label61;
    }
  }
  
  public void close()
  {
    try
    {
      if (this.mBitmapReferences == null) {
        return;
      }
      List localList = this.mBitmapReferences;
      this.mBitmapReferences = null;
      this.mBitmaps = null;
      this.mDurations = null;
      CloseableReference.closeSafely(localList);
      return;
    }
    finally {}
  }
  
  public List<Bitmap> getBitmaps()
  {
    return this.mBitmaps;
  }
  
  public List<Integer> getDurations()
  {
    return this.mDurations;
  }
  
  public int getHeight()
  {
    List localList = this.mBitmaps;
    if (localList == null) {
      return 0;
    }
    return ((Bitmap)localList.get(0)).getHeight();
  }
  
  public int getSizeInBytes()
  {
    List localList = this.mBitmaps;
    if ((localList == null) || (localList.size() == 0)) {
      return 0;
    }
    return BitmapUtil.getSizeInBytes((Bitmap)localList.get(0)) * localList.size();
  }
  
  public Bitmap getUnderlyingBitmap()
  {
    List localList = this.mBitmaps;
    if (localList != null) {
      return (Bitmap)localList.get(0);
    }
    return null;
  }
  
  public int getWidth()
  {
    List localList = this.mBitmaps;
    if (localList == null) {
      return 0;
    }
    return ((Bitmap)localList.get(0)).getWidth();
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/facebook/imagepipeline/image/CloseableAnimatedBitmap:mBitmaps	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	CloseableAnimatedBitmap
    //   6	2	1	localList	List
    //   22	4	1	localObject	Object
    //   12	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\image\CloseableAnimatedBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */