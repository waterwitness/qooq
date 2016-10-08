package com.tencent.upload.a;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.upload.common.c;
import com.tencent.upload.common.f;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

final class j
  extends c
{
  j(g paramg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message arg1)
  {
    int j = 1;
    AbstractUploadTask localAbstractUploadTask2;
    switch (???.what)
    {
    case 1: 
    case 4: 
    case 11: 
    case 13: 
    case 14: 
    default: 
    case 0: 
    case 8: 
      do
      {
        do
        {
          return;
        } while (!(???.obj instanceof AbstractUploadTask));
        AbstractUploadTask localAbstractUploadTask1 = (AbstractUploadTask)???.obj;
        b.b("ServiceImpl", "receive MSG_UPLOAD_TASK uin=" + localAbstractUploadTask1.iUin + " flowId=" + localAbstractUploadTask1.flowId + " file=" + localAbstractUploadTask1.uploadFilePath + " md5HC=" + b.a(localAbstractUploadTask1.md5) + " pathHC=" + b.a(localAbstractUploadTask1.uploadFilePath) + " " + localAbstractUploadTask1.getClass().getSimpleName());
        synchronized (g.l(this.a))
        {
          g.m(this.a).remove(localAbstractUploadTask1.flowId);
          b.a(g.j(this.a), localAbstractUploadTask1);
          g.g(this.a);
          return;
        }
      } while (!(???.obj instanceof AbstractUploadTask));
      localAbstractUploadTask2 = (AbstractUploadTask)???.obj;
      b.b("ServiceImpl", "receive MSG_UI_CANCEL_TASK flowId=" + localAbstractUploadTask2.flowId);
      b.g(localAbstractUploadTask2);
      if ((g.f(this.a) != null) && (g.f(this.a).get(localAbstractUploadTask2.flowId) != null))
      {
        b.b("ServiceImpl", "remove in mImageCompressingTasks flowId=" + localAbstractUploadTask2.flowId);
        g.f(this.a).remove(localAbstractUploadTask2.flowId);
        g.g(this.a);
      }
      break;
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (g.a(this.a).hasMessages(0, localAbstractUploadTask2))) {
        b.b("ServiceImpl", "remove in msgQueue flowId=" + localAbstractUploadTask2.flowId);
      }
      for (;;)
      {
        synchronized (g.l(this.a))
        {
          g.m(this.a).remove(localAbstractUploadTask2.flowId);
          g.a(this.a).removeMessages(0, localAbstractUploadTask2);
          i = j;
          if (i != 0)
          {
            if (localAbstractUploadTask2.uploadTaskCallback == null) {
              break;
            }
            localAbstractUploadTask2.uploadTaskCallback.onUploadStateChange(localAbstractUploadTask2, 5);
            b.b("ServiceImpl", "onUploadStateChange=5");
            return;
          }
        }
        g.b(this.a).a(((AbstractUploadTask)localObject2).flowId, 3);
        return;
        if (!(???.obj instanceof AbstractUploadTask)) {
          break;
        }
        ??? = (AbstractUploadTask)???.obj;
        if ((g.f(this.a) != null) && (g.f(this.a).get(???.flowId) != null))
        {
          b.b("ServiceImpl", "commit in mImageCompressingTasks flowId=" + ???.flowId);
          g.f(this.a).remove(???.flowId);
          g.g(this.a);
        }
        AbstractUploadTask localAbstractUploadTask3;
        synchronized (g.l(this.a))
        {
          localAbstractUploadTask3 = (AbstractUploadTask)g.m(this.a).get(???.flowId);
          if ((localAbstractUploadTask3 != null) && (g.a(this.a).hasMessages(0, localAbstractUploadTask3))) {
            b.b("ServiceImpl", "remove in msgQueue flowId=" + localAbstractUploadTask3.flowId);
          }
        }
        synchronized (g.l(this.a))
        {
          g.m(this.a).remove(localAbstractUploadTask3.flowId);
          g.a(this.a).removeMessages(0, localAbstractUploadTask3);
          g.b(this.a).a(???.flowId, 0);
          return;
          ??? = finally;
          throw ???;
        }
        b.b("ServiceImpl", "receive MSG_UI_SET_BACKGROUND_MODE=" + ???.arg1);
        if (???.arg1 == 1)
        {
          g.a(this.a, true);
          g.n(this.a).lock();
          try
          {
            if (!g.o(this.a))
            {
              g.p(this.a);
              g.a(this.a, 0L);
            }
            for (;;)
            {
              return;
              g.a(this.a, SystemClock.elapsedRealtime());
              b.a("ServiceImpl", "mEnterBackgroundIdleTime=" + g.q(this.a));
            }
            if (???.arg1 != 0) {
              break;
            }
          }
          finally
          {
            g.n(this.a).unlock();
          }
        }
        g.a(this.a, false);
        g.r(this.a);
        if ((g.q(this.a) != 0L) && (SystemClock.elapsedRealtime() - g.q(this.a) > 300000L))
        {
          b.a("ServiceImpl", "进入前台 check2doClose()");
          g.s(this.a);
        }
        g.a(this.a, 0L);
        return;
        b.b("ServiceImpl", "receive MSG_UI_SET_TEST_SERVER=" + ???.arg1);
        g.b(this.a).b(0, ???.arg1);
        g.b(this.a).b(1, ???.arg1);
        return;
        b.a("ServiceImpl", "receive MSG_INNER_TIMEOUT_CLOSE");
        g.a(this.a, "MSG_INNER_TIMEOUT_CLOSE");
        g.s(this.a);
        return;
        b.a("ServiceImpl", "receive MSG_UI_PAUSE_ALL_TASK");
        g.t(this.a);
        synchronized (g.l(this.a))
        {
          g.m(this.a).clear();
          g.b(this.a).b();
          g.a(this.a, "MSG_UI_PAUSE_ALL_TASK");
          return;
        }
        b.b("ServiceImpl", "receive MSG_UI_PREPARE");
        if (???.arg1 == 0)
        {
          g.b(this.a).a(0);
          return;
        }
        if (???.arg1 == 1)
        {
          g.b(this.a).a(1);
          return;
        }
        if (???.arg1 != 2) {
          break;
        }
        g.b(this.a).a(2);
        return;
        b.a("ServiceImpl", "receive MSG_COMPRESS_UNRELIABLE");
        g.u(this.a);
        return;
        if (???.arg1 == 0)
        {
          g.b(this.a, true);
          f.c().batchComplete();
          g.g(this.a);
          return;
        }
        if (1 != ???.arg1) {
          break;
        }
        g.b(this.a, false);
        g.v(this.a);
        return;
        g.a(this.a, "MSG_CLOSE_COMPRESS_PROCESS");
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */