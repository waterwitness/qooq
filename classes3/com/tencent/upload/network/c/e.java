package com.tencent.upload.network.c;

import android.util.SparseArray;
import com.tencent.upload.network.a.d;
import com.tencent.upload.network.b.m;
import java.lang.ref.WeakReference;

final class e
  implements Runnable
{
  e(c paramc, int paramInt) {}
  
  public final void run()
  {
    Object localObject2 = c.f(this.b);
    Object localObject1 = (c.a)((SparseArray)localObject2).get(this.a);
    if ((localObject1 == null) || (((c.a)localObject1).f != this)) {
      com.tencent.upload.a.b.d("Session", c.b(this.b) + " execute timeout runnable:" + hashCode() + " reqSeq:" + this.a + " has been removed");
    }
    label282:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            com.tencent.upload.a.b.d("Session", c.b(this.b) + " execute timeout runnable:" + hashCode() + " reqSeq:" + this.a + " actSeq:" + ((c.a)localObject1).a.f());
            ((SparseArray)localObject2).remove(this.a);
            c.g(this.b).removeCallbacks(((c.a)localObject1).f);
            ((c.a)localObject1).f = null;
            if (c.h(this.b) != 2) {
              break label282;
            }
            if ((c.c(this.b) == null) || (c.c(this.b).f() != 1)) {
              break;
            }
            localObject1 = (b)c.e(this.b).get();
          } while (localObject1 == null);
          ((b)localObject1).a(this.b, 30800, "tcp data response timeout");
          return;
          localObject2 = (b)c.e(this.b).get();
        } while (localObject2 == null);
        ((b)localObject2).a(this.b, ((c.a)localObject1).a);
        return;
        if (c.h(this.b) != 1) {
          break;
        }
        c.i(this.b);
        localObject1 = (b)c.e(this.b).get();
      } while (localObject1 == null);
      ((b)localObject1).a(this.b, 1, false);
      return;
    } while (c.h(this.b) != 0);
    com.tencent.upload.a.b.d("Session", c.b(this.b) + " execute timeout runnable:" + hashCode() + " reqSeq:" + this.a + " actSeq:" + ((c.a)localObject1).a.f() + " NO_CONNECTION!");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */