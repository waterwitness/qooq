package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseListBitmapDataSubscriber
  extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>>
{
  public void onNewResultImpl(DataSource<List<CloseableReference<CloseableImage>>> paramDataSource)
  {
    if (!paramDataSource.isFinished()) {}
    for (;;)
    {
      return;
      paramDataSource = (List)paramDataSource.getResult();
      if (paramDataSource == null)
      {
        onNewResultListImpl(null);
        return;
      }
      try
      {
        ArrayList localArrayList = new ArrayList(paramDataSource.size());
        Iterator localIterator = paramDataSource.iterator();
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            onNewResultListImpl(localArrayList);
            paramDataSource = paramDataSource.iterator();
            while (paramDataSource.hasNext()) {
              CloseableReference.closeSafely((CloseableReference)paramDataSource.next());
            }
          }
          CloseableReference localCloseableReference = (CloseableReference)localIterator.next();
          if ((localCloseableReference == null) || (!(localCloseableReference.get() instanceof CloseableBitmap))) {
            break label163;
          }
          localArrayList.add(((CloseableBitmap)localCloseableReference.get()).getUnderlyingBitmap());
        }
        if (paramDataSource.hasNext()) {}
      }
      finally
      {
        paramDataSource = paramDataSource.iterator();
      }
    }
    for (;;)
    {
      throw ((Throwable)localObject);
      label163:
      ((List)localObject).add(null);
      break;
      CloseableReference.closeSafely((CloseableReference)paramDataSource.next());
    }
  }
  
  protected abstract void onNewResultListImpl(List<Bitmap> paramList);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\datasource\BaseListBitmapDataSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */