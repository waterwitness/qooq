package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class QPTxLoader
{
  static String a;
  
  public QPTxLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = paramString.length() - 1;
    boolean bool1;
    Object localObject1;
    label117:
    Object localObject2;
    QPSupportUpdCfg localQPSupportUpdCfg;
    if ((i < 0) || (paramString.charAt(i) == '.') || (paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/'))
    {
      bool1 = bool2;
      if (i != paramString.length() - 1)
      {
        bool1 = bool2;
        if (i != 0)
        {
          bool1 = bool2;
          if (paramString.charAt(i) == '.')
          {
            localObject1 = paramString.substring(i, paramString.length() - 1).toLowerCase();
            if (!((String)localObject1).equalsIgnoreCase(".so")) {
              break label263;
            }
            localObject1 = QPTxLoader.FILETYPE.SOFILE;
            localObject2 = BaseApplication.getContext();
            a = ((Context)localObject2).getFilesDir().getAbsolutePath() + "/TxSingleUpd/";
            localQPSupportUpdCfg = new QPSupportUpdCfg();
            localQPSupportUpdCfg.ReadConfigFile(QPSupportUpdCfg.CFG_FILEPATH);
            if (!QPUpdFileOperation.a(paramString)) {
              break label283;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 == QPTxLoader.FILETYPE.SOFILE)
      {
        localObject2 = paramString;
        if (localQPSupportUpdCfg.IsFileInConfigFile(paramString))
        {
          Object localObject3 = localQPSupportUpdCfg.getFileDstPath(paramString);
          localObject2 = paramString;
          if (localObject3 != null)
          {
            localObject3 = new File((String)localObject3);
            localObject2 = paramString;
            if (localObject3 != null)
            {
              localObject2 = paramString;
              if (((File)localObject3).exists()) {
                localObject2 = localQPSupportUpdCfg.getFileDstPath(paramString);
              }
            }
          }
        }
        System.load((String)localObject2);
      }
      if (localObject1 == QPTxLoader.FILETYPE.JARFILE) {}
      bool1 = true;
      label263:
      do
      {
        return bool1;
        i -= 1;
        break;
        bool1 = bool2;
      } while (!((String)localObject1).equalsIgnoreCase(".jar"));
      localObject1 = QPTxLoader.FILETYPE.JARFILE;
      break label117;
      label283:
      paramString = ((Context)localObject2).getFilesDir().getAbsolutePath() + "/lib/" + paramString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qqprotect\singleupdate\QPTxLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */