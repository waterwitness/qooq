package com.tencent.mobileqq.vaswebviewplugin;

import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

class QWalletCommonJsPlugin$GetAllContactTask
  extends AsyncTask
{
  QWalletCommonJsPlugin$GetAllContactTask(QWalletCommonJsPlugin paramQWalletCommonJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected String doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = QWalletCommonJsPlugin.access$500(this.this$0);
    if (paramVarArgs != null) {
      return paramVarArgs.toString();
    }
    return null;
  }
  
  protected void onPostExecute(String paramString)
  {
    QWalletCommonJsPlugin.access$400(this.this$0, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\QWalletCommonJsPlugin$GetAllContactTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */