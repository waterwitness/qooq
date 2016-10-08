package com.tencent.upload.network;

import FileUpload.SvcResponsePacket;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.common.e;
import com.tencent.upload.network.b.m;
import com.tencent.upload.uinterface.IUploadAction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class c
  implements b, com.tencent.upload.network.c.b
{
  private com.tencent.upload.network.b.d a;
  private a b;
  private volatile int c;
  private com.tencent.upload.common.c d;
  private SparseArray<IUploadAction> e;
  private LinkedList<IUploadAction> f;
  private ArrayList<IUploadAction> g;
  private final int h = hashCode();
  private final WeakReference<b> i;
  private UploadConfiguration.NetworkStateObserver j;
  private final byte[] k = new byte[0];
  private String l;
  private m m;
  private HashMap<String, Integer> n;
  
  public c(com.tencent.upload.network.b.d paramd, Looper paramLooper, b paramb)
  {
    this.a = paramd;
    this.d = new com.tencent.upload.common.c(paramLooper);
    this.i = new WeakReference(paramb);
    this.c = 0;
    this.n = new HashMap();
    this.b = new a();
    this.e = new SparseArray();
    this.f = new LinkedList();
    this.g = new ArrayList(2);
    this.j = new d(this);
    UploadConfiguration.registerNetworkStateObserver(this.j);
  }
  
  private void a(int paramInt)
  {
    if (this.b == null) {}
    while (this.c == paramInt) {
      return;
    }
    this.c = paramInt;
    if (1 == paramInt) {
      this.g.clear();
    }
    com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " setDetectionState:" + e.a(paramInt));
  }
  
  private void a(com.tencent.upload.network.c.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    a(0);
    b(parama, paramInt, paramString, paramBoolean);
    if (this.f.size() == 0)
    {
      parama = (b)this.i.get();
      if (parama != null)
      {
        com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doHandleError, actions is zero, onCloseCountdown:true");
        parama.a(this, true);
      }
    }
    while (!UploadConfiguration.isNetworkAvailable()) {
      return;
    }
    a(false, paramInt);
    this.m = null;
  }
  
  private void a(com.tencent.upload.network.c.a parama, boolean paramBoolean)
  {
    a(0);
    com.tencent.upload.a.b.e("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " Detect end, NO_DETECTION !!!!!");
    String str = "causedByNoNetwork:" + paramBoolean + " falToOpenSession:" + parama.b().toString() + " ";
    str = str + this.a.b();
    b localb = (b)this.i.get();
    boolean bool1 = paramBoolean;
    if (!paramBoolean)
    {
      boolean bool2 = UploadConfiguration.openSessionTest();
      if (!bool2) {
        paramBoolean = true;
      }
      bool1 = paramBoolean;
      if (bool2)
      {
        bool1 = paramBoolean;
        if (localb != null)
        {
          localb.a(this, parama.b(), str);
          bool1 = paramBoolean;
        }
      }
    }
    b(parama, 31000, "all session establish failed:" + str, bool1);
    if ((this.f.size() == 0) && (localb != null))
    {
      com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onSetSessionNoDetection, actions is zero, onCloseCountdown:true");
      localb.a(this, true);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    a locala = this.b;
    if (this.c != 0)
    {
      com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doPerpare: detectionState != NO_DETECTION return");
      return;
    }
    Object localObject1;
    label99:
    label141:
    int i1;
    if (paramBoolean)
    {
      com.tencent.upload.a.b.b("SessionManager", this.h + "   reset needReset");
      localObject1 = this.a.a();
      if (localObject1 != null) {
        break label691;
      }
      com.tencent.upload.a.b.b("SessionManager", this.h + "   reset routes == null");
      localObject1 = this.a.a();
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        com.tencent.upload.a.b.e("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doPerpare: RouteStrategy reset no result");
        b(null, 31000, "reset null, all route has failed", false);
      }
    }
    else
    {
      if ((paramInt != 30400) && (paramInt != 30800)) {
        break label699;
      }
      i1 = 3;
      com.tencent.upload.a.b.b("SessionManager", this.h + "  TIMEOUT_FAILED change failureCode = 3 sessionError = " + paramInt);
    }
    for (;;)
    {
      if (paramInt == 30100)
      {
        i1 = 4;
        com.tencent.upload.a.b.b("SessionManager", this.h + "  SOCKET_FAILED change failureCode = 4 sessionError = " + paramInt);
      }
      if (this.m != null)
      {
        localObject1 = (Integer)this.n.get(this.m.b());
        if (((localObject1 == null) || (((Integer)localObject1).intValue() < 2)) && (paramInt != 30100)) {
          break label694;
        }
        com.tencent.upload.a.b.b("SessionManager", this.h + "   mRouteStrategy.next mErrorRoute = " + this.m);
        localObject1 = this.a.a(this.m, i1);
        break label99;
      }
      com.tencent.upload.a.b.b("SessionManager", this.h + "   mRouteStrategy.next mErrorRoute == null");
      localObject1 = this.a.a(this.m, i1);
      break label99;
      int i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        Object localObject2 = localObject1[i1];
        if (paramInt == 30100) {
          com.tencent.upload.a.b.b("SessionManager", this.h + "  NETWORK_NDK_SOCKET_ERROR chagnge route = " + localObject2);
        }
        com.tencent.upload.network.c.c localc = new com.tencent.upload.network.c.c(true, this.d.getLooper(), this);
        if (localc.a((m)localObject2)) {
          locala.a.add(localc);
        }
        i1 += 1;
      }
      if (locala.a.size() == 0)
      {
        com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doPerpare: detectionSessions.size() == 0");
        b(null, 31000, "reset connection failed", false);
        return;
      }
      a(1);
      com.tencent.upload.a.b.e("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doPerpare: detect start, DETECTING");
      localObject1 = (b)this.i.get();
      if (localObject1 == null) {
        break;
      }
      ((b)localObject1).a(this, false);
      return;
      label691:
      break label141;
      label694:
      localObject1 = null;
      break label99;
      label699:
      i1 = 0;
    }
  }
  
  private void b(com.tencent.upload.network.c.a parama)
  {
    a(2);
    this.l = UploadConfiguration.getCurrentApn();
    com.tencent.upload.a.b.e("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " Detect end, DETECTED !!!!! detectedSe:" + parama.hashCode() + " currentApn:" + this.l);
    String str = " openSession:" + parama.b().toString() + " ";
    str = str + this.a.b();
    b localb = (b)this.i.get();
    if (localb != null) {
      localb.b(this, parama.b(), str);
    }
    if (this.f.size() == 0)
    {
      if (localb != null)
      {
        com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onSetSessionDetected, actions is zero, onCloseCountdown:true");
        localb.a(this, true);
      }
      return;
    }
    e();
  }
  
  private void b(com.tencent.upload.network.c.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doNotifyError, mCurrentActions size:" + this.g.size() + " mUploadActions size:" + this.f.size() + " SeError:" + paramInt + " SeDes:" + paramString);
    if (this.g.isEmpty()) {
      if (!this.f.isEmpty()) {}
    }
    for (;;)
    {
      return;
      ((IUploadAction)this.f.get(0)).onError(parama, paramInt, paramString, paramBoolean);
      return;
      while (this.g.size() > 0) {
        ((IUploadAction)this.g.remove(0)).onError(parama, paramInt, paramString, paramBoolean);
      }
    }
  }
  
  private void e()
  {
    IUploadAction localIUploadAction;
    if (this.f.size() == 0)
    {
      localIUploadAction = null;
      if (localIUploadAction != null) {
        break label31;
      }
    }
    label31:
    a locala;
    label230:
    do
    {
      do
      {
        do
        {
          return;
          localIUploadAction = (IUploadAction)this.f.getFirst();
          break;
        } while (this.g.contains(localIUploadAction));
        this.g.add(localIUploadAction);
        com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doDriveNext doRetrieveFrist first action:" + com.tencent.upload.a.b.a(localIUploadAction) + " actSeq:" + com.tencent.upload.a.b.a(localIUploadAction) + " mCurrentActions after add, size:" + this.g.size() + " mUploadActions size:" + this.f.size());
        locala = this.b;
        if (locala.c == null) {
          break label230;
        }
      } while (localIUploadAction.onSend(locala.c));
      com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doDriveNext: action.onSend redirect Se:" + com.tencent.upload.a.b.a(locala.c) + " failed");
      return;
      if (locala.b == null) {
        break label310;
      }
    } while (localIUploadAction.onSend(locala.b));
    com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doDriveNext: action.onSend Se:" + com.tencent.upload.a.b.a(locala.b) + " failed");
    return;
    label310:
    com.tencent.upload.a.b.e("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doDriveNext: no available session");
  }
  
  private void f()
  {
    com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doCloseSession");
    a locala = this.b;
    a(0);
    while (locala.a.size() > 0) {
      ((com.tencent.upload.network.c.a)locala.a.remove(0)).a();
    }
    com.tencent.upload.network.c.a locala1;
    if (locala.b != null)
    {
      locala1 = locala.b;
      locala.b = null;
      locala1.a();
    }
    if (locala.c != null)
    {
      locala1 = locala.c;
      locala.c = null;
      locala1.a();
    }
  }
  
  private void g()
  {
    a locala = this.b;
    if ((locala.c == null) || (locala.b == null) || (!locala.b.g())) {
      return;
    }
    com.tencent.upload.network.c.a locala1 = locala.b;
    locala.b = null;
    locala1.a();
    com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " doCloseDetectedSession, close detectedSe:" + com.tencent.upload.a.b.a(locala1) + " keep redirectSe:" + com.tencent.upload.a.b.a(locala.c));
  }
  
  public final int a()
  {
    return this.a.d();
  }
  
  public final void a(com.tencent.upload.network.c.a parama)
  {
    if (parama == null) {
      com.tencent.upload.a.b.e("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onOpen: dState:" + e.a(this.c));
    }
    do
    {
      for (;;)
      {
        return;
        com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onOpen: dState:" + e.a(this.c) + " Se:" + com.tencent.upload.a.b.a(parama));
        a locala = this.b;
        boolean bool1 = locala.a.remove(parama);
        boolean bool2 = parama.f();
        if (this.c == 2)
        {
          parama.a();
          return;
        }
        if (this.c != 1) {
          break;
        }
        if (!bool1)
        {
          parama.a();
          com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onOpen: Se:" + com.tencent.upload.a.b.a(parama) + " DETECTING, !isContained");
          return;
        }
        while (locala.a.size() > 0) {
          ((com.tencent.upload.network.c.a)locala.a.remove(0)).a();
        }
        if (bool2)
        {
          locala.c = parama;
          g();
          com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onOpen, redirectSe establish:" + parama.hashCode());
        }
        while (locala.a.size() == 0)
        {
          b(parama);
          return;
          locala.b = parama;
          m localm = parama.e();
          if (localm != null)
          {
            com.tencent.upload.network.c.c localc = new com.tencent.upload.network.c.c(false, this.d.getLooper(), this);
            if (localc.a(localm))
            {
              locala.a.add(localc);
              com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onOpen, start redirect Se:" + com.tencent.upload.a.b.a(localc) + " redirectRoute:" + localm);
            }
          }
        }
      }
    } while (this.c != 0);
    parama.a();
  }
  
  public final void a(com.tencent.upload.network.c.a parama, int paramInt, String paramString)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool2;
    boolean bool1;
    label41:
    Object localObject;
    int i1;
    label198:
    String str;
    Integer localInteger;
    if (!UploadConfiguration.isNetworkAvailable())
    {
      bool2 = true;
      if ((this.l != null) && (this.l.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) == 0)) {
        break label382;
      }
      bool1 = true;
      com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " detectionState:" + e.a(this.c) + " onError: Se:" + com.tencent.upload.a.b.a(parama) + " Se error:" + paramInt + " causedByNoNetwork:" + bool2 + " causedByApnChanged:" + bool1 + " currentApn:" + UploadConfiguration.getCurrentApn() + " oldApn:" + this.l);
      this.m = null;
      if (parama != null)
      {
        localObject = parama.b();
        if ((paramInt != 30800) && (paramInt != 30400)) {
          break label388;
        }
        i1 = 1;
        if ((localObject != null) && (i1 != 0))
        {
          str = ((m)localObject).b();
          localInteger = (Integer)this.n.get(str);
          if (localInteger != null) {
            break label394;
          }
          this.n.put(str, Integer.valueOf(1));
          label248:
          UploadConfiguration.addUploadIpTimeouts(((m)localObject).b());
        }
        com.tencent.upload.a.b.b("SessionManager", this.h + " mErrorRoute = " + localObject);
        this.m = ((m)localObject);
      }
      localObject = this.b;
      if (this.c != 2) {
        break label589;
      }
      this.g.clear();
      if (parama != null) {
        parama.a();
      }
      if (parama != ((a)localObject).c) {
        break label478;
      }
      ((a)localObject).c = null;
      if (((a)localObject).b != null) {
        break label417;
      }
      if (!bool2)
      {
        bool2 = bool3;
        if (!bool1) {}
      }
      else
      {
        bool2 = true;
      }
      a(parama, paramInt, paramString, bool2);
    }
    label382:
    label388:
    label394:
    label417:
    label478:
    label589:
    do
    {
      do
      {
        return;
        bool2 = false;
        break;
        bool1 = false;
        break label41;
        i1 = 0;
        break label198;
        this.n.put(str, Integer.valueOf(localInteger.intValue() + 1));
        break label248;
        com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onError: Se:" + com.tencent.upload.a.b.a(parama) + " redirect session error, but has detected session");
        e();
        return;
      } while (parama != ((a)localObject).b);
      ((a)localObject).b = null;
      if (((a)localObject).c == null)
      {
        if (!bool2)
        {
          bool2 = bool4;
          if (!bool1) {}
        }
        else
        {
          bool2 = true;
        }
        a(parama, paramInt, paramString, bool2);
        return;
      }
      com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onError: Se:" + com.tencent.upload.a.b.a(parama) + " detected session error, but has redirect session");
      e();
      return;
      if (this.c != 1) {
        break label692;
      }
      if (parama != ((a)localObject).b)
      {
        com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " session != wrapper.detectedSession");
        return;
      }
      ((a)localObject).b = null;
    } while (((a)localObject).a.size() != 0);
    if (!bool2)
    {
      bool2 = bool5;
      if (!bool1) {}
    }
    else
    {
      bool2 = true;
    }
    a(parama, bool2);
    return;
    label692:
    com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " detectionState:" + e.a(this.c) + " mDetectionState is not DETECTING or DETECTED");
  }
  
  public final void a(com.tencent.upload.network.c.a parama, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((!UploadConfiguration.isNetworkAvailable()) || (paramBoolean))
    {
      bool1 = true;
      if (parama != null) {
        break label80;
      }
      com.tencent.upload.a.b.e("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onFailToOpen: dState:" + e.a(this.c));
    }
    label80:
    label680:
    label683:
    for (;;)
    {
      return;
      bool1 = false;
      break;
      com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onFailToOpen: dState:" + e.a(this.c) + " Se:" + com.tencent.upload.a.b.a(parama) + " failureCode:" + com.tencent.upload.network.b.b.b(paramInt) + " causedByNoNetwork:" + bool1 + " noNetwork:" + paramBoolean);
      a locala = this.b;
      paramBoolean = locala.a.remove(parama);
      boolean bool3 = parama.f();
      parama.a();
      if (this.c == 2)
      {
        com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onFailToOpen: Se:" + com.tencent.upload.a.b.a(parama) + " DETECTED, isRedirect:" + bool3 + " isContained:" + paramBoolean);
        return;
      }
      Object localObject1;
      Object localObject2;
      if (this.c == 1)
      {
        if (!paramBoolean)
        {
          com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onFailToOpen: Se:" + com.tencent.upload.a.b.a(parama) + " DETECTING, !isContained");
          return;
        }
        if ((bool3) || (bool1)) {
          break label680;
        }
        localObject1 = this.a.a(parama.b(), paramInt);
        if (localObject1 != null)
        {
          int i1 = localObject1.length;
          paramInt = 0;
          while (paramInt < i1)
          {
            localObject2 = localObject1[paramInt];
            com.tencent.upload.network.c.c localc = new com.tencent.upload.network.c.c(true, this.d.getLooper(), this);
            if (localc.a((m)localObject2)) {
              locala.a.add(localc);
            }
            paramInt += 1;
          }
          paramBoolean = false;
        }
      }
      for (;;)
      {
        if (locala.a.size() != 0) {
          break label683;
        }
        localObject2 = locala.b;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (locala.c != null) {
            localObject1 = locala.c;
          }
        }
        if (localObject1 != null)
        {
          b((com.tencent.upload.network.c.a)localObject1);
          return;
          paramBoolean = this.a.c();
          com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onFailToOpen: Se:" + com.tencent.upload.a.b.a(parama) + " causedByApnChanged:" + paramBoolean);
        }
        else
        {
          if (!bool1)
          {
            bool1 = bool2;
            if (!paramBoolean) {}
          }
          else
          {
            bool1 = true;
          }
          a(parama, bool1);
          return;
          if (this.c != 0) {
            break;
          }
          com.tencent.upload.a.b.e("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onFailToOpen: Se:" + com.tencent.upload.a.b.a(parama) + " NO_DETECTION");
          return;
          paramBoolean = false;
        }
      }
    }
  }
  
  public final void a(com.tencent.upload.network.c.a parama, com.tencent.upload.network.a.a parama1)
  {
    if (this.c == 2)
    {
      if (parama1 == null)
      {
        com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onReceive: Se:" + com.tencent.upload.a.b.a(parama) + " response == null, is Discarded...");
        return;
      }
      Object localObject = (IUploadAction)this.e.get(parama1.b());
      if (localObject == null)
      {
        localObject = new StringBuilder().append(this.h).append(" ").append(com.tencent.upload.a.b.a(this.a)).append(" detectionState:").append(e.a(this.c)).append(" onReceive: Se:").append(com.tencent.upload.a.b.a(parama)).append(" actSeq:");
        if (parama1 == null)
        {
          parama = "null";
          localObject = ((StringBuilder)localObject).append(parama).append(" cmd:");
          if (parama1 != null) {
            break label211;
          }
          parama = "null";
        }
        for (;;)
        {
          com.tencent.upload.a.b.d("SessionManager", parama + " is Discarded...");
          return;
          parama = Integer.toString(parama1.b());
          break;
          label211:
          if (parama1.a() == null) {
            parama = "null";
          } else {
            parama = Integer.toString(parama1.a().e);
          }
        }
      }
      if (parama1.d()) {
        this.a.a(parama.b());
      }
      ((IUploadAction)localObject).onResponse(parama, parama1);
      return;
    }
    com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " detectionState:" + e.a(this.c) + " onReceive: Se:" + com.tencent.upload.a.b.a(parama));
  }
  
  public final void a(com.tencent.upload.network.c.a parama, com.tencent.upload.network.a.d paramd)
  {
    com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onReceiveTimeout Se: " + com.tencent.upload.a.b.a(parama) + " actSeq:" + com.tencent.upload.a.b.a(paramd) + " reqSeq:" + com.tencent.upload.a.b.b(paramd));
    if (paramd == null) {}
    IUploadAction localIUploadAction;
    do
    {
      return;
      localIUploadAction = (IUploadAction)this.e.get(paramd.f());
    } while (localIUploadAction == null);
    if (this.c == 2)
    {
      localIUploadAction.onTimeout(parama, paramd);
      return;
    }
    com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " detectionState:" + e.a(this.c) + " onReceiveTimeout: Se:" + com.tencent.upload.a.b.a(parama));
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    return this.d.post(new j(this, paramInt1, paramInt2));
  }
  
  public final boolean a(com.tencent.upload.network.b.d paramd)
  {
    com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " switchRouteStrategy");
    synchronized (this.k)
    {
      this.d.post(new g(this, paramd));
      try
      {
        this.k.wait();
        return true;
      }
      catch (InterruptedException paramd)
      {
        for (;;)
        {
          com.tencent.upload.a.b.e("SessionManager", paramd.toString());
        }
      }
    }
  }
  
  public final boolean a(IUploadAction paramIUploadAction)
  {
    if (paramIUploadAction == null)
    {
      com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " uploadAsync: action null");
      return false;
    }
    return this.d.post(new k(this, paramIUploadAction));
  }
  
  public final void b(com.tencent.upload.network.c.a parama, com.tencent.upload.network.a.d paramd)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.h).append(" ").append(com.tencent.upload.a.b.a(this.a)).append(" onSend: Se:").append(com.tencent.upload.a.b.a(parama)).append(" actSeq:").append(com.tencent.upload.a.b.a(paramd)).append(" reqSeq:").append(com.tencent.upload.a.b.b(paramd)).append(" cmd:");
    Object localObject;
    if (paramd == null)
    {
      localObject = "null";
      com.tencent.upload.a.b.b("SessionManager", (String)localObject);
      if (paramd != null) {
        break label171;
      }
      com.tencent.upload.a.b.e("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " onSend: Se:" + com.tencent.upload.a.b.a(parama) + " request null");
    }
    label171:
    do
    {
      return;
      localObject = Integer.toString(paramd.g());
      break;
      localObject = (IUploadAction)this.e.get(paramd.f());
    } while (localObject == null);
    if (this.c == 2)
    {
      ((IUploadAction)localObject).onRequest(parama, paramd);
      return;
    }
    com.tencent.upload.a.b.d("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " detectionState:" + e.a(this.c) + " onSend: Se:" + com.tencent.upload.a.b.a(parama));
  }
  
  public final boolean b()
  {
    com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " perpareAsync");
    return this.d.post(new h(this));
  }
  
  public final void c()
  {
    com.tencent.upload.a.b.b("SessionManager", this.h + " " + com.tencent.upload.a.b.a(this.a) + " close");
    synchronized (this.k)
    {
      this.d.post(new i(this));
      try
      {
        this.k.wait();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.upload.a.b.e("SessionManager", localInterruptedException.toString());
        }
      }
    }
  }
  
  public final boolean d()
  {
    synchronized (this.k)
    {
      this.d.post(new l(this));
      try
      {
        this.k.wait();
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.upload.a.b.e("SessionManager", localInterruptedException.toString());
        }
      }
    }
  }
  
  static final class a
  {
    public ArrayList<com.tencent.upload.network.c.a> a = new ArrayList();
    public com.tencent.upload.network.c.a b;
    public com.tencent.upload.network.c.a c;
  }
  
  public static abstract interface b
  {
    public abstract void a(b paramb, m paramm, String paramString);
    
    public abstract void a(b paramb, boolean paramBoolean);
    
    public abstract void b(b paramb, m paramm, String paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */