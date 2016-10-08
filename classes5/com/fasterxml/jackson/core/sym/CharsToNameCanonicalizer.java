package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;

public final class CharsToNameCanonicalizer
{
  protected static final int DEFAULT_TABLE_SIZE = 64;
  public static final int HASH_MULT = 33;
  static final int MAX_COLL_CHAIN_FOR_REUSE = 63;
  static final int MAX_COLL_CHAIN_LENGTH = 255;
  static final int MAX_ENTRIES_FOR_REUSE = 12000;
  protected static final int MAX_TABLE_SIZE = 65536;
  static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
  protected Bucket[] _buckets;
  protected final boolean _canonicalize;
  protected boolean _dirty;
  private final int _hashSeed;
  protected int _indexMask;
  protected final boolean _intern;
  protected int _longestCollisionList;
  protected CharsToNameCanonicalizer _parent;
  protected int _size;
  protected int _sizeThreshold;
  protected String[] _symbols;
  
  private CharsToNameCanonicalizer()
  {
    this._canonicalize = true;
    this._intern = true;
    this._dirty = true;
    this._hashSeed = 0;
    this._longestCollisionList = 0;
    initTables(64);
  }
  
  private CharsToNameCanonicalizer(CharsToNameCanonicalizer paramCharsToNameCanonicalizer, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, Bucket[] paramArrayOfBucket, int paramInt1, int paramInt2, int paramInt3)
  {
    this._parent = paramCharsToNameCanonicalizer;
    this._canonicalize = paramBoolean1;
    this._intern = paramBoolean2;
    this._symbols = paramArrayOfString;
    this._buckets = paramArrayOfBucket;
    this._size = paramInt1;
    this._hashSeed = paramInt2;
    paramInt1 = paramArrayOfString.length;
    this._sizeThreshold = _thresholdSize(paramInt1);
    this._indexMask = (paramInt1 - 1);
    this._longestCollisionList = paramInt3;
    this._dirty = false;
  }
  
  private static int _thresholdSize(int paramInt)
  {
    return paramInt - (paramInt >> 2);
  }
  
  private void copyArrays()
  {
    Object localObject = this._symbols;
    int i = localObject.length;
    this._symbols = new String[i];
    System.arraycopy(localObject, 0, this._symbols, 0, i);
    localObject = this._buckets;
    i = localObject.length;
    this._buckets = new Bucket[i];
    System.arraycopy(localObject, 0, this._buckets, 0, i);
  }
  
  public static CharsToNameCanonicalizer createRoot()
  {
    long l = System.currentTimeMillis();
    return createRoot((int)l + (int)(l >>> 32) | 0x1);
  }
  
  protected static CharsToNameCanonicalizer createRoot(int paramInt)
  {
    return sBootstrapSymbolTable.makeOrphan(paramInt);
  }
  
  private void initTables(int paramInt)
  {
    this._symbols = new String[paramInt];
    this._buckets = new Bucket[paramInt >> 1];
    this._indexMask = (paramInt - 1);
    this._size = 0;
    this._longestCollisionList = 0;
    this._sizeThreshold = _thresholdSize(paramInt);
  }
  
  private CharsToNameCanonicalizer makeOrphan(int paramInt)
  {
    return new CharsToNameCanonicalizer(null, true, true, this._symbols, this._buckets, this._size, paramInt, this._longestCollisionList);
  }
  
  private void mergeChild(CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    if ((paramCharsToNameCanonicalizer.size() > 12000) || (paramCharsToNameCanonicalizer._longestCollisionList > 63)) {
      try
      {
        initTables(64);
        this._dirty = false;
        return;
      }
      finally {}
    }
    if (paramCharsToNameCanonicalizer.size() > size()) {
      try
      {
        this._symbols = paramCharsToNameCanonicalizer._symbols;
        this._buckets = paramCharsToNameCanonicalizer._buckets;
        this._size = paramCharsToNameCanonicalizer._size;
        this._sizeThreshold = paramCharsToNameCanonicalizer._sizeThreshold;
        this._indexMask = paramCharsToNameCanonicalizer._indexMask;
        this._longestCollisionList = paramCharsToNameCanonicalizer._longestCollisionList;
        this._dirty = false;
        return;
      }
      finally {}
    }
  }
  
  private void rehash()
  {
    int i1 = this._symbols.length;
    int i = i1 + i1;
    if (i > 65536)
    {
      this._size = 0;
      Arrays.fill(this._symbols, null);
      Arrays.fill(this._buckets, null);
      this._dirty = true;
      return;
    }
    Object localObject1 = this._symbols;
    Bucket[] arrayOfBucket = this._buckets;
    this._symbols = new String[i];
    this._buckets = new Bucket[i >> 1];
    this._indexMask = (i - 1);
    this._sizeThreshold = _thresholdSize(i);
    int j = 0;
    i = 0;
    int k = 0;
    if (k >= i1)
    {
      k = 0;
      m = i;
      i = k;
      k = j;
    }
    for (;;)
    {
      if (i >= i1 >> 1)
      {
        this._longestCollisionList = m;
        if (k == this._size) {
          break;
        }
        throw new Error("Internal error on SymbolTable.rehash(): had " + this._size + " entries; now have " + k + ".");
        localObject2 = localObject1[k];
        m = j;
        int n = i;
        if (localObject2 != null)
        {
          m = j + 1;
          j = _hashToIndex(calcHash((String)localObject2));
          if (this._symbols[j] != null) {
            break label265;
          }
          this._symbols[j] = localObject2;
        }
        for (n = i;; n = Math.max(i, ((Bucket)localObject2).length()))
        {
          k += 1;
          j = m;
          i = n;
          break;
          label265:
          j >>= 1;
          localObject2 = new Bucket((String)localObject2, this._buckets[j]);
          this._buckets[j] = localObject2;
        }
      }
      localObject1 = arrayOfBucket[i];
      j = m;
      if (localObject1 != null) {
        break label335;
      }
      i += 1;
      m = j;
    }
    label335:
    k += 1;
    Object localObject2 = ((Bucket)localObject1).getSymbol();
    int m = _hashToIndex(calcHash((String)localObject2));
    if (this._symbols[m] == null) {
      this._symbols[m] = localObject2;
    }
    for (;;)
    {
      localObject1 = ((Bucket)localObject1).getNext();
      break;
      m >>= 1;
      localObject2 = new Bucket((String)localObject2, this._buckets[m]);
      this._buckets[m] = localObject2;
      j = Math.max(j, ((Bucket)localObject2).length());
    }
  }
  
  public int _hashToIndex(int paramInt)
  {
    return this._indexMask & paramInt + (paramInt >>> 15);
  }
  
  public int bucketCount()
  {
    return this._symbols.length;
  }
  
  public int calcHash(String paramString)
  {
    int k = paramString.length();
    int i = this._hashSeed;
    int j = 0;
    for (;;)
    {
      if (j >= k)
      {
        j = i;
        if (i == 0) {
          j = 1;
        }
        return j;
      }
      i = i * 33 + paramString.charAt(j);
      j += 1;
    }
  }
  
  public int calcHash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramInt1 = this._hashSeed;
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 0) {
          paramInt2 = 1;
        }
        return paramInt2;
      }
      paramInt1 = paramInt1 * 33 + paramArrayOfChar[i];
      i += 1;
    }
  }
  
  public int collisionCount()
  {
    int j = 0;
    Bucket[] arrayOfBucket = this._buckets;
    int m = arrayOfBucket.length;
    int i = 0;
    for (;;)
    {
      if (i >= m) {
        return j;
      }
      Bucket localBucket = arrayOfBucket[i];
      int k = j;
      if (localBucket != null) {
        k = j + localBucket.length();
      }
      i += 1;
      j = k;
    }
  }
  
  public String findSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramInt2 < 1) {
      localObject = "";
    }
    int j;
    label64:
    label80:
    String str;
    do
    {
      return (String)localObject;
      if (!this._canonicalize) {
        return new String(paramArrayOfChar, paramInt1, paramInt2);
      }
      j = _hashToIndex(paramInt3);
      localObject = this._symbols[j];
      if (localObject == null) {
        break;
      }
      if (((String)localObject).length() == paramInt2)
      {
        paramInt3 = 0;
        if (((String)localObject).charAt(paramInt3) == paramArrayOfChar[(paramInt1 + paramInt3)]) {
          break label202;
        }
        if (paramInt3 == paramInt2) {
          break label223;
        }
      }
      localObject = this._buckets[(j >> 1)];
      if (localObject == null) {
        break;
      }
      str = ((Bucket)localObject).find(paramArrayOfChar, paramInt1, paramInt2);
      localObject = str;
    } while (str != null);
    if (!this._dirty)
    {
      copyArrays();
      this._dirty = true;
      paramInt3 = j;
      label141:
      localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
      paramArrayOfChar = (char[])localObject;
      if (this._intern) {
        paramArrayOfChar = InternCache.instance.intern((String)localObject);
      }
      this._size += 1;
      if (this._symbols[paramInt3] != null) {
        break label260;
      }
      this._symbols[paramInt3] = paramArrayOfChar;
    }
    for (;;)
    {
      return paramArrayOfChar;
      label202:
      int i = paramInt3 + 1;
      paramInt3 = i;
      if (i < paramInt2) {
        break label64;
      }
      paramInt3 = i;
      break label80;
      label223:
      break;
      paramInt3 = j;
      if (this._size < this._sizeThreshold) {
        break label141;
      }
      rehash();
      paramInt3 = _hashToIndex(calcHash(paramArrayOfChar, paramInt1, paramInt2));
      break label141;
      label260:
      paramInt1 = paramInt3 >> 1;
      localObject = new Bucket(paramArrayOfChar, this._buckets[paramInt1]);
      this._buckets[paramInt1] = localObject;
      this._longestCollisionList = Math.max(((Bucket)localObject).length(), this._longestCollisionList);
      if (this._longestCollisionList > 255) {
        reportTooManyCollisions(255);
      }
    }
  }
  
  public int hashSeed()
  {
    return this._hashSeed;
  }
  
  public CharsToNameCanonicalizer makeChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      String[] arrayOfString = this._symbols;
      Bucket[] arrayOfBucket = this._buckets;
      int i = this._size;
      int j = this._hashSeed;
      int k = this._longestCollisionList;
      return new CharsToNameCanonicalizer(this, paramBoolean1, paramBoolean2, arrayOfString, arrayOfBucket, i, j, k);
    }
    finally {}
  }
  
  public int maxCollisionLength()
  {
    return this._longestCollisionList;
  }
  
  public boolean maybeDirty()
  {
    return this._dirty;
  }
  
  public void release()
  {
    if (!maybeDirty()) {}
    while (this._parent == null) {
      return;
    }
    this._parent.mergeChild(this);
    this._dirty = false;
  }
  
  protected void reportTooManyCollisions(int paramInt)
  {
    throw new IllegalStateException("Longest collision chain in symbol table (of size " + this._size + ") now exceeds maximum, " + paramInt + " -- suspect a DoS attack based on hash collisions");
  }
  
  public int size()
  {
    return this._size;
  }
  
  static final class Bucket
  {
    private final int _length;
    private final Bucket _next;
    private final String _symbol;
    
    public Bucket(String paramString, Bucket paramBucket)
    {
      this._symbol = paramString;
      this._next = paramBucket;
      if (paramBucket == null) {}
      for (int i = 1;; i = paramBucket._length + 1)
      {
        this._length = i;
        return;
      }
    }
    
    public String find(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      String str = this._symbol;
      for (Bucket localBucket = this._next;; localBucket = localBucket.getNext())
      {
        if (str.length() == paramInt2)
        {
          int i = 0;
          if (str.charAt(i) != paramArrayOfChar[(paramInt1 + i)]) {}
          for (;;)
          {
            if (i != paramInt2) {
              break label72;
            }
            return str;
            int j = i + 1;
            i = j;
            if (j < paramInt2) {
              break;
            }
            i = j;
          }
        }
        label72:
        if (localBucket == null) {
          return null;
        }
        str = localBucket.getSymbol();
      }
    }
    
    public Bucket getNext()
    {
      return this._next;
    }
    
    public String getSymbol()
    {
      return this._symbol;
    }
    
    public int length()
    {
      return this._length;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\sym\CharsToNameCanonicalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */