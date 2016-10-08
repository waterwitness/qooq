package st;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class t
  extends d
  implements SensorEventListener
{
  private static final int d;
  private static final int e;
  private static t y;
  private boolean[] A = new boolean[6];
  private int[] B = new int[6];
  private float[] C = new float[6];
  private float[] D = new float[6];
  private float[] E = { NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F };
  private float[][] F = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 });
  private final d G = new d((byte)0);
  private final f H = new f((byte)0);
  private final a I = new a((byte)0);
  boolean c;
  private SensorManager f = null;
  private Sensor g;
  private Sensor h;
  private Sensor i;
  private Sensor j;
  private Sensor k = null;
  private long l = 0L;
  private boolean m = true;
  private float[][] n = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 });
  private float[][] o = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 });
  private float[][] p = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 });
  private float[][] q = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] r = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] s = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] t = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[] u = new float[4];
  private float[][] v = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] w = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] x = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private c z;
  
  static
  {
    int i1 = Math.round(50000.0F);
    d = i1;
    e = i1;
  }
  
  private static void a(float[] paramArrayOfFloat, float[][] paramArrayOfFloat1)
  {
    paramArrayOfFloat1[0][0] = (-paramArrayOfFloat[1]);
    paramArrayOfFloat1[0][1] = paramArrayOfFloat[0];
    paramArrayOfFloat1[0][2] = paramArrayOfFloat[2];
    paramArrayOfFloat1[1][0] = paramArrayOfFloat[1];
    paramArrayOfFloat1[1][1] = (-paramArrayOfFloat[0]);
    paramArrayOfFloat1[1][2] = paramArrayOfFloat[2];
    System.arraycopy(paramArrayOfFloat, 0, paramArrayOfFloat1[2], 0, 3);
    paramArrayOfFloat1[3][0] = (-paramArrayOfFloat[0]);
    paramArrayOfFloat1[3][1] = (-paramArrayOfFloat[1]);
    paramArrayOfFloat1[3][2] = paramArrayOfFloat[2];
    paramArrayOfFloat1[4][0] = paramArrayOfFloat[0];
    paramArrayOfFloat1[4][1] = paramArrayOfFloat[2];
    paramArrayOfFloat1[4][2] = (-paramArrayOfFloat[1]);
    paramArrayOfFloat1[5][0] = paramArrayOfFloat[0];
    paramArrayOfFloat1[5][1] = (-paramArrayOfFloat[2]);
    paramArrayOfFloat1[5][2] = paramArrayOfFloat[1];
  }
  
  private static void a(float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    int i1 = 0;
    while (i1 <= 5)
    {
      SensorManager.getOrientation(paramArrayOfFloat1[i1], paramArrayOfFloat2[i1]);
      i1 += 1;
    }
  }
  
  @TargetApi(19)
  private static boolean a(SensorManager paramSensorManager, SensorEventListener paramSensorEventListener, int paramInt1, int paramInt2, Handler paramHandler, Sensor... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          i1 = 1;
          int i3 = paramVarArgs.length;
          int i2 = 0;
          if (i2 < i3)
          {
            Sensor localSensor = paramVarArgs[i2];
            boolean bool;
            if (i1 != 0)
            {
              bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramInt2, paramHandler);
              if (!bool)
              {
                paramSensorManager.unregisterListener(paramSensorEventListener);
                return false;
              }
            }
            else
            {
              bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramHandler);
              continue;
            }
            i2 += 1;
            continue;
          }
          return true;
        }
      }
      catch (Error paramSensorManager)
      {
        return false;
      }
      catch (Exception paramSensorManager)
      {
        return false;
      }
      int i1 = 0;
    }
  }
  
  private static float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return new float[] { paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[3] + paramArrayOfFloat1[2] * paramArrayOfFloat2[6], paramArrayOfFloat1[0] * paramArrayOfFloat2[1] + paramArrayOfFloat1[1] * paramArrayOfFloat2[4] + paramArrayOfFloat1[2] * paramArrayOfFloat2[7], paramArrayOfFloat1[0] * paramArrayOfFloat2[2] + paramArrayOfFloat1[1] * paramArrayOfFloat2[5] + paramArrayOfFloat1[2] * paramArrayOfFloat2[8], paramArrayOfFloat1[3] * paramArrayOfFloat2[0] + paramArrayOfFloat1[4] * paramArrayOfFloat2[3] + paramArrayOfFloat1[5] * paramArrayOfFloat2[6], paramArrayOfFloat1[3] * paramArrayOfFloat2[1] + paramArrayOfFloat1[4] * paramArrayOfFloat2[4] + paramArrayOfFloat1[5] * paramArrayOfFloat2[7], paramArrayOfFloat1[3] * paramArrayOfFloat2[2] + paramArrayOfFloat1[4] * paramArrayOfFloat2[5] + paramArrayOfFloat1[5] * paramArrayOfFloat2[8], paramArrayOfFloat1[6] * paramArrayOfFloat2[0] + paramArrayOfFloat1[7] * paramArrayOfFloat2[3] + paramArrayOfFloat1[8] * paramArrayOfFloat2[6], paramArrayOfFloat1[6] * paramArrayOfFloat2[1] + paramArrayOfFloat1[7] * paramArrayOfFloat2[4] + paramArrayOfFloat1[8] * paramArrayOfFloat2[7], paramArrayOfFloat1[6] * paramArrayOfFloat2[2] + paramArrayOfFloat1[7] * paramArrayOfFloat2[5] + paramArrayOfFloat1[8] * paramArrayOfFloat2[8] };
  }
  
  static t b()
  {
    if (y == null) {
      y = new t();
    }
    return y;
  }
  
  final void a() {}
  
  final void a(Context paramContext) {}
  
  final void a(Context paramContext, Handler paramHandler, b.1 param1)
  {
    if (paramContext == null) {
      try
      {
        throw new Exception("SensorModule: register with null context");
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        this.c = false;
      }
    }
    label401:
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 <= 5)
      {
        this.o[i1][0] = 1065353216;
        this.o[i1][1] = 0;
        this.o[i1][2] = 0;
        this.o[i1][3] = 0;
        this.o[i1][4] = 1065353216;
        this.o[i1][5] = 0;
        this.o[i1][6] = 0;
        this.o[i1][7] = 0;
        this.o[i1][8] = 1065353216;
        i1 += 1;
      }
      this.f = ((SensorManager)paramContext.getSystemService("sensor"));
      this.g = this.f.getDefaultSensor(10);
      this.j = this.f.getDefaultSensor(9);
      boolean bool;
      if ((this.g != null) && (this.j != null))
      {
        this.k = this.f.getDefaultSensor(11);
        if (this.k != null) {
          bool = a(this.f, this, d, e, paramHandler, new Sensor[] { this.g, this.j, this.k });
        }
      }
      for (;;)
      {
        if (!bool) {
          break label401;
        }
        this.c = true;
        this.z = new c(paramHandler);
        if (this.z == null) {
          break;
        }
        this.z.a(Math.round(50.0F), 1000L);
        return;
        this.h = this.f.getDefaultSensor(4);
        this.i = this.f.getDefaultSensor(2);
        if ((this.h != null) && (this.i != null)) {
          bool = a(this.f, this, d, e, paramHandler, new Sensor[] { this.g, this.j, this.h, this.i });
        } else {
          bool = false;
        }
      }
    }
  }
  
  final void a(Handler paramHandler, b.1 param1)
    throws Exception
  {
    try
    {
      super.a(paramHandler, param1);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  final void b(Context paramContext)
  {
    if (this.z != null) {
      this.z.b();
    }
    if (this.f != null) {}
    try
    {
      this.f.unregisterListener(this);
      this.f = null;
      this.k = null;
      this.j = null;
      this.i = null;
      this.h = null;
      this.g = null;
      this.l = 0L;
      this.m = true;
      this.n = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.o = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.q = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.r = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.s = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.A = new boolean[6];
      this.B = new int[6];
      this.C = new float[6];
      this.D = new float[6];
      this.E = new float[] { NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F };
      this.F = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 }));
      this.I.a();
      this.G.a();
      this.H.a();
      return;
    }
    catch (Error paramContext)
    {
      for (;;) {}
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i2 = 0;
    int i1 = 0;
    switch (paramSensorEvent.sensor.getType())
    {
    }
    for (;;)
    {
      return;
      Object localObject3 = new float[16];
      if (this.k != null) {}
      float[] arrayOfFloat1;
      for (Object localObject1 = this.p;; localObject1 = this.o)
      {
        localObject1 = localObject1[2];
        arrayOfFloat1 = new float[16];
        if (localObject1.length == 9)
        {
          arrayOfFloat1[0] = localObject1[0];
          arrayOfFloat1[1] = localObject1[1];
          arrayOfFloat1[2] = localObject1[2];
          arrayOfFloat1[3] = 0.0F;
          arrayOfFloat1[4] = localObject1[3];
          arrayOfFloat1[5] = localObject1[4];
          arrayOfFloat1[6] = localObject1[5];
          arrayOfFloat1[7] = 0.0F;
          arrayOfFloat1[8] = localObject1[6];
          arrayOfFloat1[9] = localObject1[7];
          arrayOfFloat1[10] = localObject1[8];
          arrayOfFloat1[11] = 0.0F;
          arrayOfFloat1[12] = 0.0F;
          arrayOfFloat1[13] = 0.0F;
          arrayOfFloat1[14] = 0.0F;
          arrayOfFloat1[15] = 1.0F;
        }
        Matrix.invertM((float[])localObject3, 0, arrayOfFloat1, 0);
        Matrix.multiplyMV(this.u, 0, (float[])localObject3, 0, new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], 0.0F }, 0);
        this.G.a(this.u, paramSensorEvent.values, this.x[2]);
        return;
      }
      a(paramSensorEvent.values, this.x);
      if ((this.w[2][0] == 0.0F) && (this.w[2][1] == 0.0F) && (this.w[2][2] == 0.0F)) {
        continue;
      }
      paramSensorEvent = this.n;
      localObject1 = this.x;
      localObject3 = this.w;
      if ((SensorManager.getRotationMatrix(paramSensorEvent[0], null, localObject1[0], localObject3[0])) && (SensorManager.getRotationMatrix(paramSensorEvent[1], null, localObject1[1], localObject3[1])) && (SensorManager.getRotationMatrix(paramSensorEvent[2], null, localObject1[2], localObject3[2])) && (SensorManager.getRotationMatrix(paramSensorEvent[3], null, localObject1[3], localObject3[3])) && (SensorManager.getRotationMatrix(paramSensorEvent[4], null, localObject1[4], localObject3[4])) && (SensorManager.getRotationMatrix(paramSensorEvent[5], null, localObject1[5], localObject3[5]))) {}
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label596;
        }
        a(this.n, this.q);
        if ((this.r[2][0] != 0.0F) || (this.r[2][1] != 0.0F) || (this.r[2][2] != 0.0F)) {
          break;
        }
        paramSensorEvent = this.q;
        localObject1 = this.r;
        i1 = 0;
        while (i1 <= 5)
        {
          System.arraycopy(paramSensorEvent[i1], 0, localObject1[i1], 0, 3);
          i1 += 1;
        }
        break;
      }
      label596:
      continue;
      try
      {
        SensorManager.getRotationMatrixFromVector(this.p[2], paramSensorEvent.values);
        SensorManager.remapCoordinateSystem(this.p[2], 2, 129, this.p[0]);
        SensorManager.remapCoordinateSystem(this.p[2], 130, 1, this.p[1]);
        SensorManager.remapCoordinateSystem(this.p[2], 129, 130, this.p[3]);
        SensorManager.remapCoordinateSystem(this.p[2], 129, 3, this.p[4]);
        SensorManager.remapCoordinateSystem(this.p[2], 1, 3, this.p[5]);
        while (i1 <= 5)
        {
          SensorManager.getOrientation(this.p[i1], this.t[i1]);
          i1 += 1;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (paramSensorEvent.values.length > 3) {
            SensorManager.getRotationMatrixFromVector(this.p[2], new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2] });
          }
        }
      }
      if ((this.q[2][0] == 0.0F) && (this.q[2][1] == 0.0F) && (this.q[2][2] == 0.0F)) {
        continue;
      }
      if (this.m)
      {
        i1 = 0;
        while (i1 <= 5)
        {
          localObject2 = this.n[i1];
          this.o[i1] = a(this.o[i1], (float[])localObject2);
          i1 += 1;
        }
        this.m = false;
      }
      Object localObject2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 4 });
      float f1;
      float f2;
      float f3;
      if (this.l != 0L)
      {
        f1 = (float)(paramSensorEvent.timestamp - this.l);
        a(paramSensorEvent.values, this.v);
        i1 = 0;
        while (i1 <= 5)
        {
          localObject3 = this.v[i1];
          arrayOfFloat1 = localObject2[i1];
          f2 = 1.0E-9F * f1 / 2.0F;
          float[] arrayOfFloat2 = new float[3];
          f3 = (float)Math.sqrt(localObject3[0] * localObject3[0] + localObject3[1] * localObject3[1] + localObject3[2] * localObject3[2]);
          if (f3 > 1.0E-9F)
          {
            localObject3[0] /= f3;
            localObject3[1] /= f3;
            localObject3[2] /= f3;
          }
          f3 *= f2;
          f2 = (float)Math.sin(f3);
          f3 = (float)Math.cos(f3);
          arrayOfFloat2[0] *= f2;
          arrayOfFloat2[1] *= f2;
          arrayOfFloat1[2] = (f2 * arrayOfFloat2[2]);
          arrayOfFloat1[3] = f3;
          i1 += 1;
        }
      }
      this.l = paramSensorEvent.timestamp;
      i1 = i2;
      label1152:
      if (i1 <= 5) {
        paramSensorEvent = new float[9];
      }
      try
      {
        SensorManager.getRotationMatrixFromVector(paramSensorEvent, localObject2[i1]);
        this.o[i1] = a(this.o[i1], paramSensorEvent);
        i1 += 1;
        break label1152;
        a(this.o, this.r);
        return;
        a(paramSensorEvent.values, this.w);
        localObject2 = this.I;
        paramSensorEvent = paramSensorEvent.values;
        if (paramSensorEvent.length < 3) {
          continue;
        }
        ((a)localObject2).a += 1;
        double d1 = ((a)localObject2).b;
        f1 = paramSensorEvent[0];
        f2 = paramSensorEvent[0];
        f3 = paramSensorEvent[1];
        float f4 = paramSensorEvent[1];
        float f5 = paramSensorEvent[2];
        ((a)localObject2).b = ((float)(Math.sqrt(f2 * f1 + f4 * f3 + paramSensorEvent[2] * f5) + d1));
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  static final class a
  {
    int a = 0;
    float b = 0.0F;
    long c = 0L;
    float d = 0.0F;
    boolean e = false;
    long f = 0L;
    float[] g = new float[6];
    float[] h = new float[6];
    float[] i = new float[6];
    float[] j = new float[6];
    float[] k = new float[6];
    float[] l = new float[6];
    float[] m = new float[6];
    float[] n = new float[6];
    float[] o = new float[6];
    float p = 0.0F;
    float q = Float.NEGATIVE_INFINITY;
    float r = Float.POSITIVE_INFINITY;
    
    final void a()
    {
      this.a = 0;
      this.b = 0.0F;
      this.c = 0L;
      this.d = 0.0F;
      this.e = false;
      this.f = 0L;
      this.g = new float[6];
      this.h = new float[6];
      this.i = new float[6];
      this.p = 0.0F;
      this.q = Float.NEGATIVE_INFINITY;
      this.r = Float.POSITIVE_INFINITY;
    }
  }
  
  static final class b
  {
    long a;
    float b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    float k;
    float l;
    float[] m = new float[6];
    float[] n = new float[6];
    float[] o = new float[6];
    float[] p = new float[6];
    float[] q = new float[6];
  }
  
  final class c
    extends e
  {
    c(Handler paramHandler)
    {
      super();
    }
    
    final void a()
    {
      t.a(t.this);
    }
  }
  
  static final class d
  {
    private int a = 0;
    private float b = 0.0F;
    private float c = 0.0F;
    private float d = 0.0F;
    private float e = 0.0F;
    private float f = 0.0F;
    private float g = 0.0F;
    private float h = 0.0F;
    private float i = 0.0F;
    private float j = 0.0F;
    
    /* Error */
    final t.b a(float[][] paramArrayOfFloat)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 24	st/t$d:a	I
      //   8: ifle +13 -> 21
      //   11: aload_1
      //   12: arraylength
      //   13: istore 4
      //   15: iload 4
      //   17: iconst_3
      //   18: if_icmpge +9 -> 27
      //   21: aconst_null
      //   22: astore_1
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_1
      //   26: areturn
      //   27: new 48	st/t$b
      //   30: dup
      //   31: iconst_0
      //   32: invokespecial 50	st/t$b:<init>	(B)V
      //   35: astore_2
      //   36: aload_2
      //   37: invokestatic 56	android/os/SystemClock:elapsedRealtime	()J
      //   40: putfield 59	st/t$b:a	J
      //   43: iload_3
      //   44: iconst_5
      //   45: if_icmpgt +77 -> 122
      //   48: aload_2
      //   49: getfield 63	st/t$b:m	[F
      //   52: iload_3
      //   53: aload_1
      //   54: iload_3
      //   55: aaload
      //   56: iconst_0
      //   57: faload
      //   58: fastore
      //   59: aload_2
      //   60: getfield 66	st/t$b:n	[F
      //   63: iload_3
      //   64: aload_1
      //   65: iload_3
      //   66: aaload
      //   67: iconst_1
      //   68: faload
      //   69: fastore
      //   70: aload_2
      //   71: getfield 69	st/t$b:o	[F
      //   74: iload_3
      //   75: aload_1
      //   76: iload_3
      //   77: aaload
      //   78: iconst_2
      //   79: faload
      //   80: fastore
      //   81: aload_2
      //   82: getfield 72	st/t$b:p	[F
      //   85: iload_3
      //   86: aload_2
      //   87: getfield 63	st/t$b:m	[F
      //   90: iload_3
      //   91: faload
      //   92: f2d
      //   93: invokestatic 78	java/lang/Math:sin	(D)D
      //   96: d2f
      //   97: fastore
      //   98: aload_2
      //   99: getfield 81	st/t$b:q	[F
      //   102: iload_3
      //   103: aload_2
      //   104: getfield 63	st/t$b:m	[F
      //   107: iload_3
      //   108: faload
      //   109: f2d
      //   110: invokestatic 84	java/lang/Math:cos	(D)D
      //   113: d2f
      //   114: fastore
      //   115: iload_3
      //   116: iconst_1
      //   117: iadd
      //   118: istore_3
      //   119: goto -76 -> 43
      //   122: aload_2
      //   123: aload_0
      //   124: getfield 26	st/t$d:b	F
      //   127: aload_0
      //   128: getfield 24	st/t$d:a	I
      //   131: i2f
      //   132: fdiv
      //   133: putfield 85	st/t$b:b	F
      //   136: aload_2
      //   137: aload_0
      //   138: getfield 28	st/t$d:c	F
      //   141: aload_0
      //   142: getfield 24	st/t$d:a	I
      //   145: i2f
      //   146: fdiv
      //   147: putfield 86	st/t$b:c	F
      //   150: aload_2
      //   151: aload_0
      //   152: getfield 30	st/t$d:d	F
      //   155: aload_0
      //   156: getfield 24	st/t$d:a	I
      //   159: i2f
      //   160: fdiv
      //   161: putfield 87	st/t$b:d	F
      //   164: aload_2
      //   165: aload_0
      //   166: getfield 32	st/t$d:e	F
      //   169: aload_0
      //   170: getfield 24	st/t$d:a	I
      //   173: i2f
      //   174: fdiv
      //   175: putfield 88	st/t$b:e	F
      //   178: aload_2
      //   179: aload_0
      //   180: getfield 34	st/t$d:f	F
      //   183: aload_0
      //   184: getfield 24	st/t$d:a	I
      //   187: i2f
      //   188: fdiv
      //   189: putfield 89	st/t$b:f	F
      //   192: aload_2
      //   193: aload_0
      //   194: getfield 36	st/t$d:g	F
      //   197: aload_0
      //   198: getfield 24	st/t$d:a	I
      //   201: i2f
      //   202: fdiv
      //   203: putfield 90	st/t$b:g	F
      //   206: aload_2
      //   207: aload_0
      //   208: getfield 38	st/t$d:h	F
      //   211: aload_0
      //   212: getfield 24	st/t$d:a	I
      //   215: i2f
      //   216: fdiv
      //   217: putfield 91	st/t$b:h	F
      //   220: aload_2
      //   221: aload_0
      //   222: getfield 40	st/t$d:i	F
      //   225: aload_0
      //   226: getfield 24	st/t$d:a	I
      //   229: i2f
      //   230: fdiv
      //   231: putfield 92	st/t$b:i	F
      //   234: aload_2
      //   235: aload_0
      //   236: getfield 42	st/t$d:j	F
      //   239: aload_0
      //   240: getfield 24	st/t$d:a	I
      //   243: i2f
      //   244: fdiv
      //   245: putfield 93	st/t$b:j	F
      //   248: aload_2
      //   249: aload_2
      //   250: getfield 85	st/t$b:b	F
      //   253: aload_2
      //   254: getfield 85	st/t$b:b	F
      //   257: fmul
      //   258: aload_2
      //   259: getfield 86	st/t$b:c	F
      //   262: aload_2
      //   263: getfield 86	st/t$b:c	F
      //   266: fmul
      //   267: fadd
      //   268: f2d
      //   269: invokestatic 96	java/lang/Math:sqrt	(D)D
      //   272: d2f
      //   273: putfield 99	st/t$b:l	F
      //   276: aload_0
      //   277: invokevirtual 101	st/t$d:a	()V
      //   280: aload_2
      //   281: astore_1
      //   282: goto -259 -> 23
      //   285: astore_1
      //   286: aload_0
      //   287: monitorexit
      //   288: aload_1
      //   289: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	290	0	this	d
      //   0	290	1	paramArrayOfFloat	float[][]
      //   35	246	2	localb	t.b
      //   1	118	3	k	int
      //   13	6	4	m	int
      // Exception table:
      //   from	to	target	type
      //   4	15	285	finally
      //   27	43	285	finally
      //   48	115	285	finally
      //   122	280	285	finally
    }
    
    final void a()
    {
      try
      {
        this.a = 0;
        this.b = 0.0F;
        this.c = 0.0F;
        this.d = 0.0F;
        this.e = 0.0F;
        this.f = 0.0F;
        this.g = 0.0F;
        this.h = 0.0F;
        this.i = 0.0F;
        this.j = 0.0F;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    final void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
    {
      try
      {
        if (paramArrayOfFloat1.length >= 3)
        {
          this.a += 1;
          this.b += paramArrayOfFloat1[0];
          this.c += paramArrayOfFloat1[1];
          this.d += paramArrayOfFloat1[2];
          this.e += paramArrayOfFloat2[0];
          this.f += paramArrayOfFloat2[1];
          this.g += paramArrayOfFloat2[2];
          this.h += paramArrayOfFloat3[0];
          this.i += paramArrayOfFloat3[1];
          this.j += paramArrayOfFloat3[2];
        }
        return;
      }
      finally
      {
        paramArrayOfFloat1 = finally;
        throw paramArrayOfFloat1;
      }
    }
  }
  
  static final class e
    extends o
  {
    final float a;
    final float b;
    final float c;
    final float d;
    final float e;
    final int f;
    
    private e(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5)
    {
      super();
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.f = paramInt;
      this.c = paramFloat3;
      this.d = paramFloat4;
      this.e = paramFloat5;
    }
  }
  
  final class f
  {
    private ArrayList<t.b> a = new ArrayList();
    private a[] b = new a[5];
    private int c = 0;
    private float[][] d = { { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F } };
    private float[][] e = { { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F } };
    private float[][] f = (float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 });
    private int[] g = new int[6];
    private int h = 5;
    private int i = -1;
    private int j = 0;
    
    private f() {}
    
    /* Error */
    private void a(a parama)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 40	st/t$f:b	[Lst/t$f$a;
      //   6: iconst_1
      //   7: aload_0
      //   8: getfield 40	st/t$f:b	[Lst/t$f$a;
      //   11: iconst_0
      //   12: iconst_4
      //   13: invokestatic 84	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   16: aload_0
      //   17: getfield 40	st/t$f:b	[Lst/t$f$a;
      //   20: iconst_4
      //   21: aaload
      //   22: ifnull +138 -> 160
      //   25: invokestatic 90	android/os/SystemClock:elapsedRealtime	()J
      //   28: aload_1
      //   29: getfield 93	st/t$f$a:h	J
      //   32: lsub
      //   33: ldc2_w 94
      //   36: lcmp
      //   37: ifle +123 -> 160
      //   40: aload_0
      //   41: getfield 40	st/t$f:b	[Lst/t$f$a;
      //   44: iconst_4
      //   45: aaload
      //   46: astore_2
      //   47: aload_2
      //   48: aload_2
      //   49: getfield 98	st/t$f$a:a	F
      //   52: aload_1
      //   53: getfield 98	st/t$f$a:a	F
      //   56: fadd
      //   57: fconst_2
      //   58: fdiv
      //   59: putfield 98	st/t$f$a:a	F
      //   62: aload_2
      //   63: aload_2
      //   64: getfield 100	st/t$f$a:b	F
      //   67: aload_1
      //   68: getfield 100	st/t$f$a:b	F
      //   71: fadd
      //   72: fconst_2
      //   73: fdiv
      //   74: putfield 100	st/t$f$a:b	F
      //   77: aload_2
      //   78: aload_2
      //   79: getfield 102	st/t$f$a:c	F
      //   82: aload_1
      //   83: getfield 102	st/t$f$a:c	F
      //   86: fadd
      //   87: fconst_2
      //   88: fdiv
      //   89: putfield 102	st/t$f$a:c	F
      //   92: aload_2
      //   93: aload_2
      //   94: getfield 104	st/t$f$a:d	I
      //   97: aload_1
      //   98: getfield 104	st/t$f$a:d	I
      //   101: iadd
      //   102: i2f
      //   103: fconst_2
      //   104: fdiv
      //   105: invokestatic 110	java/lang/Math:round	(F)I
      //   108: putfield 104	st/t$f$a:d	I
      //   111: aload_2
      //   112: aload_2
      //   113: getfield 112	st/t$f$a:e	F
      //   116: aload_1
      //   117: getfield 112	st/t$f$a:e	F
      //   120: fadd
      //   121: fconst_2
      //   122: fdiv
      //   123: putfield 112	st/t$f$a:e	F
      //   126: aload_2
      //   127: aload_2
      //   128: getfield 114	st/t$f$a:f	F
      //   131: aload_1
      //   132: getfield 114	st/t$f$a:f	F
      //   135: fadd
      //   136: fconst_2
      //   137: fdiv
      //   138: putfield 114	st/t$f$a:f	F
      //   141: aload_2
      //   142: aload_1
      //   143: getfield 93	st/t$f$a:h	J
      //   146: putfield 93	st/t$f$a:h	J
      //   149: aload_2
      //   150: aload_1
      //   151: getfield 116	st/t$f$a:g	F
      //   154: putfield 116	st/t$f$a:g	F
      //   157: aload_0
      //   158: monitorexit
      //   159: return
      //   160: aload_0
      //   161: getfield 40	st/t$f:b	[Lst/t$f$a;
      //   164: iconst_4
      //   165: aload_1
      //   166: aastore
      //   167: goto -10 -> 157
      //   170: astore_1
      //   171: aload_0
      //   172: monitorexit
      //   173: aload_1
      //   174: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	175	0	this	f
      //   0	175	1	parama	a
      //   46	104	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	157	170	finally
      //   160	167	170	finally
    }
    
    /* Error */
    private boolean c()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 42	st/t$f:c	I
      //   6: bipush 20
      //   8: if_icmplt +703 -> 711
      //   11: aload_0
      //   12: getfield 48	st/t$f:d	[[F
      //   15: iconst_0
      //   16: aaload
      //   17: astore 16
      //   19: aload 16
      //   21: iconst_2
      //   22: aload 16
      //   24: iconst_2
      //   25: faload
      //   26: ldc 118
      //   28: fdiv
      //   29: fastore
      //   30: aload_0
      //   31: getfield 48	st/t$f:d	[[F
      //   34: iconst_1
      //   35: aaload
      //   36: astore 16
      //   38: aload 16
      //   40: iconst_2
      //   41: aload 16
      //   43: iconst_2
      //   44: faload
      //   45: ldc 118
      //   47: fdiv
      //   48: fastore
      //   49: aload_0
      //   50: getfield 48	st/t$f:d	[[F
      //   53: iconst_2
      //   54: aaload
      //   55: astore 16
      //   57: aload 16
      //   59: iconst_2
      //   60: aload 16
      //   62: iconst_2
      //   63: faload
      //   64: ldc 118
      //   66: fdiv
      //   67: fastore
      //   68: aload_0
      //   69: getfield 50	st/t$f:e	[[F
      //   72: iconst_0
      //   73: aaload
      //   74: astore 16
      //   76: aload 16
      //   78: iconst_2
      //   79: aload 16
      //   81: iconst_2
      //   82: faload
      //   83: ldc 118
      //   85: fdiv
      //   86: fastore
      //   87: aload_0
      //   88: getfield 50	st/t$f:e	[[F
      //   91: iconst_1
      //   92: aaload
      //   93: astore 16
      //   95: aload 16
      //   97: iconst_2
      //   98: aload 16
      //   100: iconst_2
      //   101: faload
      //   102: ldc 118
      //   104: fdiv
      //   105: fastore
      //   106: aload_0
      //   107: getfield 50	st/t$f:e	[[F
      //   110: iconst_2
      //   111: aaload
      //   112: astore 16
      //   114: aload 16
      //   116: iconst_2
      //   117: aload 16
      //   119: iconst_2
      //   120: faload
      //   121: ldc 118
      //   123: fdiv
      //   124: fastore
      //   125: aload_0
      //   126: getfield 50	st/t$f:e	[[F
      //   129: iconst_0
      //   130: aaload
      //   131: iconst_2
      //   132: faload
      //   133: fstore_1
      //   134: aload_0
      //   135: getfield 48	st/t$f:d	[[F
      //   138: iconst_0
      //   139: aaload
      //   140: iconst_0
      //   141: faload
      //   142: fstore_2
      //   143: aload_0
      //   144: getfield 48	st/t$f:d	[[F
      //   147: iconst_0
      //   148: aaload
      //   149: iconst_2
      //   150: faload
      //   151: fstore_3
      //   152: aload_0
      //   153: getfield 48	st/t$f:d	[[F
      //   156: iconst_0
      //   157: aaload
      //   158: iconst_2
      //   159: faload
      //   160: fstore 4
      //   162: aload_0
      //   163: getfield 48	st/t$f:d	[[F
      //   166: iconst_0
      //   167: aaload
      //   168: iconst_1
      //   169: faload
      //   170: fstore 5
      //   172: aload_0
      //   173: getfield 50	st/t$f:e	[[F
      //   176: iconst_1
      //   177: aaload
      //   178: iconst_2
      //   179: faload
      //   180: fstore 6
      //   182: aload_0
      //   183: getfield 48	st/t$f:d	[[F
      //   186: iconst_1
      //   187: aaload
      //   188: iconst_0
      //   189: faload
      //   190: fstore 7
      //   192: aload_0
      //   193: getfield 48	st/t$f:d	[[F
      //   196: iconst_1
      //   197: aaload
      //   198: iconst_2
      //   199: faload
      //   200: fstore 8
      //   202: aload_0
      //   203: getfield 48	st/t$f:d	[[F
      //   206: iconst_1
      //   207: aaload
      //   208: iconst_2
      //   209: faload
      //   210: fstore 9
      //   212: aload_0
      //   213: getfield 48	st/t$f:d	[[F
      //   216: iconst_1
      //   217: aaload
      //   218: iconst_1
      //   219: faload
      //   220: fstore 10
      //   222: aload_0
      //   223: getfield 50	st/t$f:e	[[F
      //   226: iconst_2
      //   227: aaload
      //   228: iconst_2
      //   229: faload
      //   230: fstore 11
      //   232: aload_0
      //   233: getfield 48	st/t$f:d	[[F
      //   236: iconst_2
      //   237: aaload
      //   238: iconst_0
      //   239: faload
      //   240: fstore 12
      //   242: aload_0
      //   243: getfield 48	st/t$f:d	[[F
      //   246: iconst_2
      //   247: aaload
      //   248: iconst_2
      //   249: faload
      //   250: fstore 13
      //   252: aload_0
      //   253: getfield 48	st/t$f:d	[[F
      //   256: iconst_2
      //   257: aaload
      //   258: iconst_2
      //   259: faload
      //   260: fstore 14
      //   262: aload_0
      //   263: getfield 48	st/t$f:d	[[F
      //   266: iconst_2
      //   267: aaload
      //   268: iconst_1
      //   269: faload
      //   270: fstore 15
      //   272: aload_0
      //   273: getfield 65	st/t$f:f	[[F
      //   276: iconst_0
      //   277: aaload
      //   278: iconst_0
      //   279: fload_1
      //   280: ldc 119
      //   282: fmul
      //   283: ldc 120
      //   285: aload_0
      //   286: getfield 65	st/t$f:f	[[F
      //   289: iconst_0
      //   290: aaload
      //   291: iconst_0
      //   292: faload
      //   293: fmul
      //   294: fadd
      //   295: fastore
      //   296: aload_0
      //   297: getfield 65	st/t$f:f	[[F
      //   300: iconst_0
      //   301: aaload
      //   302: iconst_1
      //   303: fload_2
      //   304: fload_3
      //   305: fsub
      //   306: ldc 119
      //   308: fmul
      //   309: ldc 120
      //   311: aload_0
      //   312: getfield 65	st/t$f:f	[[F
      //   315: iconst_0
      //   316: aaload
      //   317: iconst_1
      //   318: faload
      //   319: fmul
      //   320: fadd
      //   321: fastore
      //   322: aload_0
      //   323: getfield 65	st/t$f:f	[[F
      //   326: iconst_0
      //   327: aaload
      //   328: iconst_2
      //   329: fload 4
      //   331: fload 5
      //   333: fsub
      //   334: ldc 119
      //   336: fmul
      //   337: ldc 120
      //   339: aload_0
      //   340: getfield 65	st/t$f:f	[[F
      //   343: iconst_0
      //   344: aaload
      //   345: iconst_2
      //   346: faload
      //   347: fmul
      //   348: fadd
      //   349: fastore
      //   350: aload_0
      //   351: getfield 65	st/t$f:f	[[F
      //   354: iconst_1
      //   355: aaload
      //   356: iconst_0
      //   357: ldc 120
      //   359: aload_0
      //   360: getfield 65	st/t$f:f	[[F
      //   363: iconst_1
      //   364: aaload
      //   365: iconst_0
      //   366: faload
      //   367: fmul
      //   368: fload 6
      //   370: ldc 119
      //   372: fmul
      //   373: fadd
      //   374: fastore
      //   375: aload_0
      //   376: getfield 65	st/t$f:f	[[F
      //   379: iconst_1
      //   380: aaload
      //   381: iconst_1
      //   382: ldc 120
      //   384: aload_0
      //   385: getfield 65	st/t$f:f	[[F
      //   388: iconst_1
      //   389: aaload
      //   390: iconst_1
      //   391: faload
      //   392: fmul
      //   393: ldc 119
      //   395: fload 7
      //   397: fload 8
      //   399: fsub
      //   400: fmul
      //   401: fadd
      //   402: fastore
      //   403: aload_0
      //   404: getfield 65	st/t$f:f	[[F
      //   407: iconst_1
      //   408: aaload
      //   409: iconst_2
      //   410: ldc 120
      //   412: aload_0
      //   413: getfield 65	st/t$f:f	[[F
      //   416: iconst_1
      //   417: aaload
      //   418: iconst_2
      //   419: faload
      //   420: fmul
      //   421: ldc 119
      //   423: fload 9
      //   425: fload 10
      //   427: fsub
      //   428: fmul
      //   429: fadd
      //   430: fastore
      //   431: aload_0
      //   432: getfield 65	st/t$f:f	[[F
      //   435: iconst_2
      //   436: aaload
      //   437: iconst_0
      //   438: ldc 120
      //   440: aload_0
      //   441: getfield 65	st/t$f:f	[[F
      //   444: iconst_2
      //   445: aaload
      //   446: iconst_0
      //   447: faload
      //   448: fmul
      //   449: ldc 119
      //   451: fload 11
      //   453: fmul
      //   454: fadd
      //   455: fastore
      //   456: aload_0
      //   457: getfield 65	st/t$f:f	[[F
      //   460: iconst_2
      //   461: aaload
      //   462: iconst_1
      //   463: ldc 120
      //   465: aload_0
      //   466: getfield 65	st/t$f:f	[[F
      //   469: iconst_2
      //   470: aaload
      //   471: iconst_1
      //   472: faload
      //   473: fmul
      //   474: ldc 119
      //   476: fload 12
      //   478: fload 13
      //   480: fsub
      //   481: fmul
      //   482: fadd
      //   483: fastore
      //   484: aload_0
      //   485: getfield 65	st/t$f:f	[[F
      //   488: iconst_2
      //   489: aaload
      //   490: iconst_2
      //   491: ldc 120
      //   493: aload_0
      //   494: getfield 65	st/t$f:f	[[F
      //   497: iconst_2
      //   498: aaload
      //   499: iconst_2
      //   500: faload
      //   501: fmul
      //   502: ldc 119
      //   504: fload 14
      //   506: fload 15
      //   508: fsub
      //   509: fmul
      //   510: fadd
      //   511: fastore
      //   512: aload_0
      //   513: aload_0
      //   514: invokespecial 123	st/t$f:d	()Lst/t$f$a;
      //   517: invokespecial 125	st/t$f:a	(Lst/t$f$a;)V
      //   520: aload_0
      //   521: iconst_0
      //   522: putfield 42	st/t$f:c	I
      //   525: iconst_3
      //   526: newarray <illegal type>
      //   528: dup
      //   529: iconst_0
      //   530: ldc 45
      //   532: fastore
      //   533: dup
      //   534: iconst_1
      //   535: ldc 46
      //   537: fastore
      //   538: dup
      //   539: iconst_2
      //   540: fconst_0
      //   541: fastore
      //   542: astore 16
      //   544: iconst_3
      //   545: newarray <illegal type>
      //   547: dup
      //   548: iconst_0
      //   549: ldc 45
      //   551: fastore
      //   552: dup
      //   553: iconst_1
      //   554: ldc 46
      //   556: fastore
      //   557: dup
      //   558: iconst_2
      //   559: fconst_0
      //   560: fastore
      //   561: astore 17
      //   563: aload_0
      //   564: iconst_3
      //   565: anewarray 44	[F
      //   568: dup
      //   569: iconst_0
      //   570: aload 16
      //   572: aastore
      //   573: dup
      //   574: iconst_1
      //   575: iconst_3
      //   576: newarray <illegal type>
      //   578: dup
      //   579: iconst_0
      //   580: ldc 45
      //   582: fastore
      //   583: dup
      //   584: iconst_1
      //   585: ldc 46
      //   587: fastore
      //   588: dup
      //   589: iconst_2
      //   590: fconst_0
      //   591: fastore
      //   592: aastore
      //   593: dup
      //   594: iconst_2
      //   595: aload 17
      //   597: aastore
      //   598: putfield 48	st/t$f:d	[[F
      //   601: aload_0
      //   602: iconst_3
      //   603: anewarray 44	[F
      //   606: dup
      //   607: iconst_0
      //   608: iconst_3
      //   609: newarray <illegal type>
      //   611: dup
      //   612: iconst_0
      //   613: ldc 45
      //   615: fastore
      //   616: dup
      //   617: iconst_1
      //   618: ldc 46
      //   620: fastore
      //   621: dup
      //   622: iconst_2
      //   623: fconst_0
      //   624: fastore
      //   625: aastore
      //   626: dup
      //   627: iconst_1
      //   628: iconst_3
      //   629: newarray <illegal type>
      //   631: dup
      //   632: iconst_0
      //   633: ldc 45
      //   635: fastore
      //   636: dup
      //   637: iconst_1
      //   638: ldc 46
      //   640: fastore
      //   641: dup
      //   642: iconst_2
      //   643: fconst_0
      //   644: fastore
      //   645: aastore
      //   646: dup
      //   647: iconst_2
      //   648: iconst_3
      //   649: newarray <illegal type>
      //   651: dup
      //   652: iconst_0
      //   653: ldc 45
      //   655: fastore
      //   656: dup
      //   657: iconst_1
      //   658: ldc 46
      //   660: fastore
      //   661: dup
      //   662: iconst_2
      //   663: fconst_0
      //   664: fastore
      //   665: aastore
      //   666: putfield 50	st/t$f:e	[[F
      //   669: aload_0
      //   670: getfield 38	st/t$f:a	Ljava/util/ArrayList;
      //   673: invokevirtual 129	java/util/ArrayList:size	()I
      //   676: bipush 100
      //   678: if_icmplt +25 -> 703
      //   681: aload_0
      //   682: getfield 38	st/t$f:a	Ljava/util/ArrayList;
      //   685: iconst_0
      //   686: bipush 20
      //   688: invokevirtual 133	java/util/ArrayList:subList	(II)Ljava/util/List;
      //   691: invokeinterface 138 1 0
      //   696: aload_0
      //   697: getfield 38	st/t$f:a	Ljava/util/ArrayList;
      //   700: invokevirtual 141	java/util/ArrayList:trimToSize	()V
      //   703: iconst_1
      //   704: istore 18
      //   706: aload_0
      //   707: monitorexit
      //   708: iload 18
      //   710: ireturn
      //   711: iconst_0
      //   712: istore 18
      //   714: goto -8 -> 706
      //   717: astore 16
      //   719: aload_0
      //   720: monitorexit
      //   721: aload 16
      //   723: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	724	0	this	f
      //   133	147	1	f1	float
      //   142	162	2	f2	float
      //   151	154	3	f3	float
      //   160	170	4	f4	float
      //   170	162	5	f5	float
      //   180	189	6	f6	float
      //   190	206	7	f7	float
      //   200	198	8	f8	float
      //   210	214	9	f9	float
      //   220	206	10	f10	float
      //   230	222	11	f11	float
      //   240	237	12	f12	float
      //   250	229	13	f13	float
      //   260	245	14	f14	float
      //   270	237	15	f15	float
      //   17	554	16	arrayOfFloat1	float[]
      //   717	5	16	localObject	Object
      //   561	35	17	arrayOfFloat2	float[]
      //   704	9	18	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	703	717	finally
    }
    
    private a d()
    {
      int i5;
      label39:
      int n;
      label56:
      a locala2;
      int i1;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      float f1;
      float f2;
      float f3;
      label276:
      label384:
      int i3;
      int i6;
      int i4;
      int i7;
      int i2;
      try
      {
        if (this.j != 0) {
          break label1720;
        }
        i5 = 1;
        Object localObject4;
        t.b localb;
        if (i5 != 0)
        {
          if (Math.abs(this.f[2][0]) >= 9.3D) {
            break label1726;
          }
          m = 5;
          this.h = m;
          this.g = new int[6];
          n = 0;
          if ((this.i >= 0) && (this.i <= 5)) {
            this.h = this.i;
          }
          localObject4 = new a((byte)0);
          locala2 = new a((byte)0);
          if (this.b[0] != null)
          {
            ((a)localObject4).h = this.b[0].h;
            ((a)localObject4).e = this.b[0].e;
          }
          if (this.b[4] != null)
          {
            locala2.h = this.b[4].h;
            locala2.e = this.b[4].e;
          }
          if (this.a.isEmpty()) {
            break label1443;
          }
          i1 = this.a.size();
          localObject5 = new float[6];
          localObject6 = new float[6];
          localObject7 = this.a.iterator();
          f1 = 0.0F;
          f2 = 0.0F;
          if (!((Iterator)localObject7).hasNext()) {
            break label669;
          }
          localb = (t.b)((Iterator)localObject7).next();
          if (n != 0) {
            break label600;
          }
        }
        label525:
        label557:
        label600:
        for (f3 = localb.d;; f3 = localb.g)
        {
          f3 = f2 + f3;
          if (n != 0) {
            break label610;
          }
          f2 = localb.l;
          break label1708;
          for (;;)
          {
            Object localObject1;
            f1 = localObject1;
            f2 = f3;
            if (m > 5) {
              break;
            }
            localObject5[m] += localb.p[m];
            localObject6[m] += localb.q[m];
            m += 1;
          }
          if (Math.abs(this.f[0][0]) < 7.0F) {
            break label1738;
          }
          if (this.f[1][1] >= 2.3F) {
            break label1732;
          }
          if (this.f[1][2] < 2.3F) {
            break label1738;
          }
          break label1732;
          if (m != 0)
          {
            this.h = 2;
            this.g = new int[6];
            n = m;
            break;
          }
          f1 = Math.abs(this.f[0][0]);
          f2 = Math.abs(this.f[1][0]);
          f3 = Math.abs(this.f[2][0]);
          if (f1 <= f2) {
            break label1803;
          }
          if (f1 <= f3) {
            break label1797;
          }
          n = 0;
          break label1744;
          i6 = i3;
          i7 = i4;
          f2 = f1;
          if (i2 >= 3) {
            break label1823;
          }
          f2 = f1;
          if (this.f[i1][i2] <= f1) {
            break label1785;
          }
          f2 = this.f[i1][i2];
          i4 = i1;
          i3 = i2;
          break label1785;
          n = (i4 << 1) + i3 - 1;
          localObject4 = this.g;
          localObject4[n] += 1;
          n = 0;
          if (n > 5) {
            break label1701;
          }
          if ((n == this.h) || (this.g[n] <= this.g[this.h])) {
            break label1843;
          }
          this.h = n;
          break label1843;
        }
        label610:
        f2 = (float)Math.sqrt(localb.e * localb.e + localb.f * localb.f + localb.g * localb.g);
        localb.k = f2;
      }
      finally {}
      label669:
      float f11 = f2 / i1;
      float f5 = f1 / i1;
      float f13;
      float f7;
      float f6;
      label828:
      label841:
      float f4;
      float f10;
      label890:
      label940:
      label950:
      Object localObject2;
      float f12;
      float f8;
      if (n == 0)
      {
        f13 = f11;
        localObject7 = new float[6];
        localObject7[0] = ((float)Math.atan2(localObject5[0], localObject6[0]));
        localObject7[1] = ((float)Math.atan2(localObject5[1], localObject6[1]));
        localObject7[2] = ((float)Math.atan2(localObject5[2], localObject6[2]));
        localObject7[3] = ((float)Math.atan2(localObject5[3], localObject6[3]));
        localObject7[4] = ((float)Math.atan2(localObject5[4], localObject6[4]));
        localObject7[5] = ((float)Math.atan2(localObject5[5], localObject6[5]));
        m = 0;
        f7 = 0.0F;
        f6 = 0.0F;
        if (n != 0) {
          break label1894;
        }
        f3 = f11;
        break label1852;
        localObject5 = this.a.iterator();
        f2 = f5;
        if (((Iterator)localObject5).hasNext())
        {
          localObject6 = (t.b)((Iterator)localObject5).next();
          if (n == 0) {}
          Object localObject3;
          for (f4 = ((t.b)localObject6).d;; f4 = ((t.b)localObject6).k)
          {
            if (n != 0) {
              break label940;
            }
            f10 = ((t.b)localObject6).l;
            break label1875;
            if (m > 0) {
              break label950;
            }
            if (f4 > localObject3) {
              break label1921;
            }
            f7 = localObject6.p[this.h];
            f6 = localObject6.q[this.h];
            break;
          }
          f10 = ((t.b)localObject6).k;
          break label1875;
          f12 = localObject2;
          f8 = f3;
          if (f3 >= f4) {
            break label1946;
          }
          if (i5 != 0) {
            break label1669;
          }
          f3 = f4 - localObject3;
          if (f3 <= 2.0F * localObject2) {
            break label1669;
          }
          f12 = f3 / 2.0F;
          f8 = f4;
          break label1946;
          label1001:
          f2 = f1;
          if (m <= 10)
          {
            i1 = 1;
            m = i1;
            if (locala1.h == 0L) {
              break label1991;
            }
            m = i1;
            if (((t.b)localObject6).a - locala1.h >= 250L) {
              break label1991;
            }
            m = 0;
            break label1991;
          }
        }
      }
      label1151:
      label1307:
      label1443:
      label1662:
      label1669:
      label1701:
      label1708:
      label1720:
      label1726:
      label1732:
      label1738:
      label1744:
      label1785:
      label1797:
      label1803:
      label1823:
      label1841:
      label1843:
      label1852:
      float f9;
      float f14;
      for (;;)
      {
        f2 = f1;
        if (i1 != 0)
        {
          a.a(locala1);
          f4 = f1 + f8;
          f1 = localObject6.p[this.h];
          f2 = localObject6.q[this.h];
          f2 = (float)Math.atan2(f7 + f1, f6 + f2);
          f6 = Math.abs(f2 - localObject7[this.h]);
          f1 = f6;
          if (f6 <= 3.1415927F) {
            break label2021;
          }
          f1 = 6.2831855F - f6;
          break label2021;
        }
        for (;;)
        {
          f6 = (float)(Math.sin(f2) * f1);
          double d1 = Math.cos(f2);
          f1 = (float)(f1 * d1);
          a.a(locala1, f6);
          a.b(locala1, f1);
          f2 = f4;
          if (((t.b)localObject6).a - locala2.h > 250L)
          {
            locala2.a -= f6;
            locala2.b -= f1;
            a.a(locala2);
            f2 = f4;
          }
          locala1.h = ((t.b)localObject6).a;
          m = 0;
          f7 = localObject6.p[this.h];
          f6 = localObject6.q[this.h];
          f4 = f2;
          f1 = f12;
          f2 = f3;
          f3 = f4;
          f4 = f8;
          break;
          f2 = localObject7[this.h];
        }
        if (locala1.d > 0) {
          if (n != 0) {
            break label1662;
          }
        }
        for (f2 = 0.0F;; f2 = 0.08F)
        {
          f1 /= locala1.d;
          f3 = locala1.e;
          f2 += (f1 - f13) / 15.0F + 0.537F;
          f1 = f2;
          if (f3 != 0.0F) {
            f1 = f2 * 0.67F + 0.33F * f3;
          }
          locala1.e = f1;
          locala1.a = (locala1.e * locala1.a);
          locala1.b = (locala1.e * locala1.b);
          locala1.f = (locala1.d * locala1.e);
          locala1.g = (locala1.f / (this.a.size() / 20));
          if (this.b[0] != null)
          {
            a.a(locala1, this.b[0].a);
            a.b(locala1, this.b[0].b);
            locala1.c = (this.b[0].c + locala1.c);
            locala1.d = (this.b[0].d + locala1.d);
            locala1.f = (this.b[0].f + locala1.f);
          }
          if ((this.b[4] != null) && (locala2.d > 0))
          {
            this.b[4].a = ((this.b[4].a + locala1.a + locala2.a * locala1.e) / 2.0F);
            this.b[4].b = ((this.b[4].b + locala1.b + locala2.b * locala1.e) / 2.0F);
          }
          return locala1;
        }
        f8 = f4;
        f12 = localObject2;
        break label1946;
        label1875:
        float f15;
        label1894:
        label1907:
        label1914:
        label1921:
        do
        {
          f4 = f1;
          f8 = f3;
          f1 = localObject2;
          f3 = f4;
          f4 = f8;
          break label2044;
          n = m;
          break label56;
          f4 = f1 + f2;
          m = 0;
          break label276;
          i5 = 0;
          break;
          m = 2;
          break label39;
          m = 1;
          break label384;
          m = 0;
          break label384;
          f1 = 0.0F;
          i4 = 0;
          i3 = 0;
          i1 = 0;
          for (;;)
          {
            if (i1 >= 3) {
              break label1841;
            }
            i6 = i3;
            i7 = i4;
            f2 = f1;
            if (i1 != n)
            {
              i2 = 1;
              break;
              i2 += 1;
              f1 = f2;
              break;
              n = 2;
              break label1744;
              if (f2 > f3)
              {
                n = 1;
                break label1744;
              }
              n = 2;
              break label1744;
            }
            i1 += 1;
            i3 = i6;
            i4 = i7;
            f1 = f2;
          }
          break label525;
          n += 1;
          break label557;
          f1 = 0.0F;
          if (n == 0) {}
          for (f9 = 1.2F;; f9 = 1.0F)
          {
            if (i5 == 0) {
              break label1907;
            }
            f14 = 0.08726647F;
            break label828;
            if (n != 0) {
              break label1914;
            }
            f15 = f11;
            break label890;
            f13 = f5;
            break;
            f3 = f5;
            break label1852;
          }
          f14 = 0.2617994F;
          break label828;
          f15 = f5;
          break label890;
        } while (f4 - f15 < f9);
        m = 1;
        f2 = f10;
        f3 = f4;
        break label841;
        label1946:
        f3 = f2;
        if (f2 < f10) {
          f3 = f10;
        }
        if (f4 <= f15) {
          break label1001;
        }
        m += 1;
        f9 = f12;
        f2 = f3;
        f3 = f8;
        break label841;
        label1991:
        i1 = m;
        if (m != 0)
        {
          i1 = m;
          if (f3 - f5 < 0.3F) {
            i1 = 0;
          }
        }
      }
      label2021:
      if (f1 >= f14) {}
      for (int m = 1;; m = 0)
      {
        f1 = 1.0F;
        if (m == 0) {
          break label1307;
        }
        f1 = 0.93F;
        break label1151;
        label2044:
        f9 = f1;
        f1 = f3;
        f3 = f4;
        break;
      }
    }
    
    final void a()
    {
      try
      {
        this.a.clear();
        this.b = new a[5];
        this.c = 0;
        this.d = new float[][] { { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F } };
        this.e = new float[][] { { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F } };
        this.f = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
        this.g = new int[6];
        this.h = 5;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    final void a(t.b paramb)
    {
      try
      {
        if ((this.j > 0) && (this.j < 101)) {
          this.j -= 1;
        }
        this.a.add(paramb);
        this.c += 1;
        if (paramb.e > this.d[0][0]) {
          this.d[0][0] = paramb.e;
        }
        if (paramb.e < this.d[0][1]) {
          this.d[0][1] = paramb.e;
        }
        float[] arrayOfFloat = this.d[0];
        arrayOfFloat[2] += paramb.e;
        if (paramb.f > this.d[1][0]) {
          this.d[1][0] = paramb.f;
        }
        if (paramb.f < this.d[1][1]) {
          this.d[1][1] = paramb.f;
        }
        arrayOfFloat = this.d[1];
        arrayOfFloat[2] += paramb.f;
        if (paramb.g > this.d[2][0]) {
          this.d[2][0] = paramb.g;
        }
        if (paramb.g < this.d[2][1]) {
          this.d[2][1] = paramb.g;
        }
        arrayOfFloat = this.d[2];
        arrayOfFloat[2] += paramb.g;
        if (paramb.h > this.e[0][0]) {
          this.e[0][0] = paramb.h;
        }
        if (paramb.h < this.e[0][1]) {
          this.e[0][1] = paramb.h;
        }
        arrayOfFloat = this.e[0];
        arrayOfFloat[2] += paramb.h;
        if (paramb.i > this.e[1][0]) {
          this.e[1][0] = paramb.i;
        }
        if (paramb.i < this.e[1][1]) {
          this.e[1][1] = paramb.i;
        }
        arrayOfFloat = this.e[1];
        arrayOfFloat[2] += paramb.i;
        if (paramb.j > this.e[2][0]) {
          this.e[2][0] = paramb.j;
        }
        if (paramb.j < this.e[2][1]) {
          this.e[2][1] = paramb.j;
        }
        arrayOfFloat = this.e[2];
        arrayOfFloat[2] += paramb.j;
        if (c()) {
          t.b(t.this);
        }
        return;
      }
      finally {}
    }
    
    /* Error */
    final a b()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 40	st/t$f:b	[Lst/t$f$a;
      //   6: iconst_4
      //   7: aaload
      //   8: ifnull +17 -> 25
      //   11: aload_0
      //   12: getfield 40	st/t$f:b	[Lst/t$f$a;
      //   15: iconst_4
      //   16: aaload
      //   17: invokevirtual 241	st/t$f$a:a	()Lst/t$f$a;
      //   20: astore_1
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: areturn
      //   25: aconst_null
      //   26: astore_1
      //   27: goto -6 -> 21
      //   30: astore_1
      //   31: aload_0
      //   32: monitorexit
      //   33: aload_1
      //   34: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	35	0	this	f
      //   20	7	1	locala	a
      //   30	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	21	30	finally
    }
    
    final class a
    {
      float a = 0.0F;
      float b = 0.0F;
      float c = 0.0F;
      int d = 0;
      float e = 0.0F;
      float f = 0.0F;
      float g = 0.0F;
      long h = 0L;
      
      private a() {}
      
      protected final a a()
      {
        a locala = new a(t.f.this);
        locala.a = this.a;
        locala.b = this.b;
        locala.c = this.c;
        locala.d = this.d;
        locala.e = this.e;
        locala.f = this.f;
        locala.h = this.h;
        locala.g = this.g;
        return locala;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */