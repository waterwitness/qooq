package com.tencent.component.network.utils.a;

import com.tencent.component.network.utils.a.b.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;

final class c
  extends a<HttpRoute, OperatedClientConnection, d>
{
  private static AtomicLong a = new AtomicLong();
  private final long b;
  private final TimeUnit c;
  
  public c(long paramLong, TimeUnit paramTimeUnit)
  {
    super(new a());
    this.b = paramLong;
    this.c = paramTimeUnit;
  }
  
  static final class a
    implements com.tencent.component.network.utils.a.b.d<HttpRoute, OperatedClientConnection>
  {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */