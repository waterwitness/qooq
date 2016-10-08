package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

public abstract interface LoaderManager$LoaderCallbacks
{
  public abstract Loader onCreateLoader(int paramInt, Bundle paramBundle);
  
  public abstract void onLoadFinished(Loader paramLoader, Object paramObject);
  
  public abstract void onLoaderReset(Loader paramLoader);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\android\support\v4\app\LoaderManager$LoaderCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */