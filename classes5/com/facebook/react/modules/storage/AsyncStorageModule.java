package com.facebook.react.modules.storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SetBuilder;
import com.facebook.react.modules.common.ModuleDataCleaner.Cleanable;
import java.util.HashSet;
import java.util.Iterator;

public final class AsyncStorageModule
  extends ReactContextBaseJavaModule
  implements ModuleDataCleaner.Cleanable
{
  private static final int MAX_SQL_KEYS = 999;
  private ReactDatabaseSupplier mReactDatabaseSupplier;
  private boolean mShuttingDown = false;
  
  public AsyncStorageModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(paramReactApplicationContext);
  }
  
  private boolean ensureDatabase()
  {
    return (!this.mShuttingDown) && (this.mReactDatabaseSupplier.ensureDatabase());
  }
  
  @ReactMethod
  public void clear(final Callback paramCallback)
  {
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void... paramAnonymousVarArgs)
      {
        if (!AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase())
        {
          paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null) });
          return;
        }
        try
        {
          AsyncStorageModule.this.mReactDatabaseSupplier.clear();
          paramCallback.invoke(new Object[0]);
          return;
        }
        catch (Exception paramAnonymousVarArgs)
        {
          if (FLog.isLoggable(5)) {
            FLog.w("React", paramAnonymousVarArgs.getMessage(), paramAnonymousVarArgs);
          }
          paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getError(null, paramAnonymousVarArgs.getMessage()) });
        }
      }
    }.execute(new Void[0]);
  }
  
  public void clearSensitiveData()
  {
    this.mReactDatabaseSupplier.clearAndCloseDatabase();
  }
  
  @ReactMethod
  public void getAllKeys(final Callback paramCallback)
  {
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void... paramAnonymousVarArgs)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null), null });
          return;
        }
        WritableArray localWritableArray = Arguments.createArray();
        paramAnonymousVarArgs = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", new String[] { "key" }, null, null, null, null, null);
        try
        {
          if (paramAnonymousVarArgs.moveToFirst())
          {
            boolean bool;
            do
            {
              localWritableArray.pushString(paramAnonymousVarArgs.getString(0));
              bool = paramAnonymousVarArgs.moveToNext();
            } while (bool);
          }
          paramAnonymousVarArgs.close();
          paramCallback.invoke(new Object[] { null, localWritableArray });
          return;
        }
        catch (Exception localException)
        {
          if (FLog.isLoggable(5)) {
            FLog.w("React", localException.getMessage(), localException);
          }
          paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getError(null, localException.getMessage()), null });
          return;
        }
        finally
        {
          paramAnonymousVarArgs.close();
        }
      }
    }.execute(new Void[0]);
  }
  
  public String getName()
  {
    return "AsyncSQLiteDBStorage";
  }
  
  public void initialize()
  {
    super.initialize();
    this.mShuttingDown = false;
  }
  
  @ReactMethod
  public void multiGet(final ReadableArray paramReadableArray, final Callback paramCallback)
  {
    if (paramReadableArray == null)
    {
      paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getInvalidKeyError(null), null });
      return;
    }
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void... paramAnonymousVarArgs)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null), null });
          return;
        }
        paramAnonymousVarArgs = SetBuilder.newHashSet();
        WritableArray localWritableArray = Arguments.createArray();
        int i = 0;
        while (i < paramReadableArray.size())
        {
          int k = Math.min(paramReadableArray.size() - i, 999);
          Object localObject1 = AsyncStorageModule.this.mReactDatabaseSupplier.get();
          Object localObject2 = AsyncLocalStorageUtil.buildKeySelection(k);
          Object localObject3 = AsyncLocalStorageUtil.buildKeySelectionArgs(paramReadableArray, i, k);
          localObject1 = ((SQLiteDatabase)localObject1).query("catalystLocalStorage", new String[] { "key", "value" }, (String)localObject2, (String[])localObject3, null, null, null);
          paramAnonymousVarArgs.clear();
          try
          {
            if (((Cursor)localObject1).getCount() != paramReadableArray.size())
            {
              int j = i;
              while (j < i + k)
              {
                paramAnonymousVarArgs.add(paramReadableArray.getString(j));
                j += 1;
              }
            }
            if (((Cursor)localObject1).moveToFirst())
            {
              boolean bool;
              do
              {
                localObject2 = Arguments.createArray();
                ((WritableArray)localObject2).pushString(((Cursor)localObject1).getString(0));
                ((WritableArray)localObject2).pushString(((Cursor)localObject1).getString(1));
                localWritableArray.pushArray((WritableArray)localObject2);
                paramAnonymousVarArgs.remove(((Cursor)localObject1).getString(0));
                bool = ((Cursor)localObject1).moveToNext();
              } while (bool);
            }
            ((Cursor)localObject1).close();
            localObject1 = paramAnonymousVarArgs.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              localObject3 = Arguments.createArray();
              ((WritableArray)localObject3).pushString((String)localObject2);
              ((WritableArray)localObject3).pushNull();
              localWritableArray.pushArray((WritableArray)localObject3);
            }
            paramAnonymousVarArgs.clear();
          }
          catch (Exception paramAnonymousVarArgs)
          {
            if (FLog.isLoggable(5)) {
              FLog.w("React", paramAnonymousVarArgs.getMessage(), paramAnonymousVarArgs);
            }
            paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getError(null, paramAnonymousVarArgs.getMessage()), null });
            return;
          }
          finally
          {
            ((Cursor)localObject1).close();
          }
          i += 999;
        }
        paramCallback.invoke(new Object[] { null, localWritableArray });
      }
    }.execute(new Void[0]);
  }
  
  @ReactMethod
  public void multiMerge(final ReadableArray paramReadableArray, final Callback paramCallback)
  {
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void... paramAnonymousVarArgs)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null) });
          return;
        }
        paramAnonymousVarArgs = null;
        for (;;)
        {
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
            int i = 0;
            if (i < paramReadableArray.size())
            {
              if (paramReadableArray.getArray(i).size() != 2)
              {
                paramAnonymousVarArgs = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException1)
                {
                  if (FLog.isLoggable(5)) {
                    FLog.w("React", localException1.getMessage(), localException1);
                  }
                }
                if (paramAnonymousVarArgs != null) {
                  break;
                }
                AsyncStorageErrorUtil.getError(null, localException1.getMessage());
                return;
              }
              if (paramReadableArray.getArray(i).getString(0) == null)
              {
                paramAnonymousVarArgs = AsyncStorageErrorUtil.getInvalidKeyError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException2)
                {
                  if (FLog.isLoggable(5)) {
                    FLog.w("React", localException2.getMessage(), localException2);
                  }
                }
                if (paramAnonymousVarArgs != null) {
                  break;
                }
                AsyncStorageErrorUtil.getError(null, localException2.getMessage());
                return;
              }
              if (paramReadableArray.getArray(i).getString(1) == null)
              {
                paramAnonymousVarArgs = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException3)
                {
                  if (FLog.isLoggable(5)) {
                    FLog.w("React", localException3.getMessage(), localException3);
                  }
                }
                if (paramAnonymousVarArgs != null) {
                  break;
                }
                AsyncStorageErrorUtil.getError(null, localException3.getMessage());
                return;
              }
              if (!AsyncLocalStorageUtil.mergeImpl(AsyncStorageModule.this.mReactDatabaseSupplier.get(), paramReadableArray.getArray(i).getString(0), paramReadableArray.getArray(i).getString(1)))
              {
                paramAnonymousVarArgs = AsyncStorageErrorUtil.getDBError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException4)
                {
                  if (FLog.isLoggable(5)) {
                    FLog.w("React", localException4.getMessage(), localException4);
                  }
                }
                if (paramAnonymousVarArgs != null) {
                  break;
                }
                AsyncStorageErrorUtil.getError(null, localException4.getMessage());
                return;
              }
              i += 1;
              continue;
            }
            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
          }
          catch (Exception paramAnonymousVarArgs)
          {
            if (!FLog.isLoggable(5)) {
              continue;
            }
            FLog.w("React", paramAnonymousVarArgs.getMessage(), paramAnonymousVarArgs);
            WritableMap localWritableMap = AsyncStorageErrorUtil.getError(null, paramAnonymousVarArgs.getMessage());
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              paramAnonymousVarArgs = localWritableMap;
            }
            catch (Exception localException7)
            {
              if (FLog.isLoggable(5)) {
                FLog.w("React", localException7.getMessage(), localException7);
              }
              paramAnonymousVarArgs = localWritableMap;
            }
            if (localWritableMap != null) {
              continue;
            }
            paramAnonymousVarArgs = AsyncStorageErrorUtil.getError(null, localException7.getMessage());
            continue;
          }
          finally
          {
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              throw paramAnonymousVarArgs;
            }
            catch (Exception localException6)
            {
              if (FLog.isLoggable(5)) {
                FLog.w("React", localException6.getMessage(), localException6);
              }
              if (0 != 0) {
                continue;
              }
              AsyncStorageErrorUtil.getError(null, localException6.getMessage());
              continue;
            }
            paramCallback.invoke(new Object[0]);
          }
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
            if (paramAnonymousVarArgs != null)
            {
              paramCallback.invoke(new Object[] { paramAnonymousVarArgs });
              return;
            }
          }
          catch (Exception localException5)
          {
            if (FLog.isLoggable(5)) {
              FLog.w("React", localException5.getMessage(), localException5);
            }
            if (0 == 0) {
              paramAnonymousVarArgs = AsyncStorageErrorUtil.getError(null, localException5.getMessage());
            }
          }
        }
      }
    }.execute(new Void[0]);
  }
  
  @ReactMethod
  public void multiRemove(final ReadableArray paramReadableArray, final Callback paramCallback)
  {
    if (paramReadableArray.size() == 0)
    {
      paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getInvalidKeyError(null) });
      return;
    }
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void... paramAnonymousVarArgs)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null) });
          return;
        }
        paramAnonymousVarArgs = null;
        for (;;)
        {
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
            int i = 0;
            if (i < paramReadableArray.size())
            {
              int j = Math.min(paramReadableArray.size() - i, 999);
              AsyncStorageModule.this.mReactDatabaseSupplier.get().delete("catalystLocalStorage", AsyncLocalStorageUtil.buildKeySelection(j), AsyncLocalStorageUtil.buildKeySelectionArgs(paramReadableArray, i, j));
              i += 999;
              continue;
            }
            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
          }
          catch (Exception paramAnonymousVarArgs)
          {
            if (!FLog.isLoggable(5)) {
              continue;
            }
            FLog.w("React", paramAnonymousVarArgs.getMessage(), paramAnonymousVarArgs);
            WritableMap localWritableMap = AsyncStorageErrorUtil.getError(null, paramAnonymousVarArgs.getMessage());
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              paramAnonymousVarArgs = localWritableMap;
            }
            catch (Exception localException3)
            {
              if (FLog.isLoggable(5)) {
                FLog.w("React", localException3.getMessage(), localException3);
              }
              paramAnonymousVarArgs = localWritableMap;
            }
            if (localWritableMap != null) {
              continue;
            }
            paramAnonymousVarArgs = AsyncStorageErrorUtil.getError(null, localException3.getMessage());
            continue;
          }
          finally
          {
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              throw paramAnonymousVarArgs;
            }
            catch (Exception localException2)
            {
              if (FLog.isLoggable(5)) {
                FLog.w("React", localException2.getMessage(), localException2);
              }
              if (0 != 0) {
                continue;
              }
              AsyncStorageErrorUtil.getError(null, localException2.getMessage());
              continue;
            }
            paramCallback.invoke(new Object[0]);
          }
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
            if (paramAnonymousVarArgs != null)
            {
              paramCallback.invoke(new Object[] { paramAnonymousVarArgs });
              return;
            }
          }
          catch (Exception localException1)
          {
            if (FLog.isLoggable(5)) {
              FLog.w("React", localException1.getMessage(), localException1);
            }
            if (0 == 0) {
              paramAnonymousVarArgs = AsyncStorageErrorUtil.getError(null, localException1.getMessage());
            }
          }
        }
      }
    }.execute(new Void[0]);
  }
  
  @ReactMethod
  public void multiSet(final ReadableArray paramReadableArray, final Callback paramCallback)
  {
    if (paramReadableArray.size() == 0)
    {
      paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getInvalidKeyError(null) });
      return;
    }
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void... paramAnonymousVarArgs)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null) });
          return;
        }
        SQLiteStatement localSQLiteStatement = AsyncStorageModule.this.mReactDatabaseSupplier.get().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
        paramAnonymousVarArgs = null;
        for (;;)
        {
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
            int i = 0;
            if (i < paramReadableArray.size())
            {
              if (paramReadableArray.getArray(i).size() != 2)
              {
                paramAnonymousVarArgs = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException1)
                {
                  if (FLog.isLoggable(5)) {
                    FLog.w("React", localException1.getMessage(), localException1);
                  }
                }
                if (paramAnonymousVarArgs != null) {
                  break;
                }
                AsyncStorageErrorUtil.getError(null, localException1.getMessage());
                return;
              }
              if (paramReadableArray.getArray(i).getString(0) == null)
              {
                paramAnonymousVarArgs = AsyncStorageErrorUtil.getInvalidKeyError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException2)
                {
                  if (FLog.isLoggable(5)) {
                    FLog.w("React", localException2.getMessage(), localException2);
                  }
                }
                if (paramAnonymousVarArgs != null) {
                  break;
                }
                AsyncStorageErrorUtil.getError(null, localException2.getMessage());
                return;
              }
              if (paramReadableArray.getArray(i).getString(1) == null)
              {
                paramAnonymousVarArgs = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException3)
                {
                  if (FLog.isLoggable(5)) {
                    FLog.w("React", localException3.getMessage(), localException3);
                  }
                }
                if (paramAnonymousVarArgs != null) {
                  break;
                }
                AsyncStorageErrorUtil.getError(null, localException3.getMessage());
                return;
              }
              localException3.clearBindings();
              localException3.bindString(1, paramReadableArray.getArray(i).getString(0));
              localException3.bindString(2, paramReadableArray.getArray(i).getString(1));
              localException3.execute();
              i += 1;
              continue;
            }
            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
          }
          catch (Exception paramAnonymousVarArgs)
          {
            if (!FLog.isLoggable(5)) {
              continue;
            }
            FLog.w("React", paramAnonymousVarArgs.getMessage(), paramAnonymousVarArgs);
            WritableMap localWritableMap = AsyncStorageErrorUtil.getError(null, paramAnonymousVarArgs.getMessage());
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              paramAnonymousVarArgs = localWritableMap;
            }
            catch (Exception localException6)
            {
              if (FLog.isLoggable(5)) {
                FLog.w("React", localException6.getMessage(), localException6);
              }
              paramAnonymousVarArgs = localWritableMap;
            }
            if (localWritableMap != null) {
              continue;
            }
            paramAnonymousVarArgs = AsyncStorageErrorUtil.getError(null, localException6.getMessage());
            continue;
          }
          finally
          {
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              throw paramAnonymousVarArgs;
            }
            catch (Exception localException5)
            {
              if (FLog.isLoggable(5)) {
                FLog.w("React", localException5.getMessage(), localException5);
              }
              if (0 != 0) {
                continue;
              }
              AsyncStorageErrorUtil.getError(null, localException5.getMessage());
              continue;
            }
            paramCallback.invoke(new Object[0]);
          }
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
            if (paramAnonymousVarArgs != null)
            {
              paramCallback.invoke(new Object[] { paramAnonymousVarArgs });
              return;
            }
          }
          catch (Exception localException4)
          {
            if (FLog.isLoggable(5)) {
              FLog.w("React", localException4.getMessage(), localException4);
            }
            if (0 == 0) {
              paramAnonymousVarArgs = AsyncStorageErrorUtil.getError(null, localException4.getMessage());
            }
          }
        }
      }
    }.execute(new Void[0]);
  }
  
  public void onCatalystInstanceDestroy()
  {
    this.mShuttingDown = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\storage\AsyncStorageModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */