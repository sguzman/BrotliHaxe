// Generated by Haxe 3.4.0
package encode.histogram;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Histogram extends haxe.lang.HxObject
{
	public Histogram(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Histogram(int kDataSize)
	{
		//line 42 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		encode.histogram.Histogram.__hx_ctor_encode_histogram_Histogram(this, kDataSize);
	}
	
	
	public static void __hx_ctor_encode_histogram_Histogram(encode.histogram.Histogram __hx_this, int kDataSize)
	{
		//line 44 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		__hx_this.kDataSize = kDataSize;
		//line 45 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		int[] this1 = new int[kDataSize];
		//line 45 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		__hx_this.data_ = ((int[]) (this1) );
		//line 46 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		__hx_this.Clear();
	}
	
	
	public void Clear()
	{
		//line 13 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		haxe.root.DefaultFunctions.memset_Int(this.data_, 0, 0, ((int[]) (this.data_) ).length);
		//line 14 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		this.total_count_ = 0;
	}
	
	
	public void Add1(int val)
	{
		//line 17 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		((int[]) (this.data_) )[val] += 1;
		//line 18 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		 ++ this.total_count_;
	}
	
	
	public void Remove(int val)
	{
		//line 21 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		((int[]) (this.data_) )[val] -= 1;
		//line 22 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		 -- this.total_count_;
	}
	
	
	public void Add2(haxe.root.Array<java.lang.Object> p, int p_off, int n)
	{
		//line 26 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		this.total_count_ += n;
		//line 27 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		 ++ n;
		//line 28 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		while ((  -- n > 0 ))
		{
			//line 28 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			int _g = ((int) (haxe.lang.Runtime.toInt(p.__get(p_off++))) );
			//line 28 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			((int[]) (this.data_) )[_g] += 1;
		}
		
	}
	
	
	public void AddHistogram(encode.histogram.Histogram v)
	{
		//line 31 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		this.total_count_ += v.total_count_;
		//line 32 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		{
			//line 32 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			int _g1 = 0;
			//line 32 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			int _g = this.kDataSize;
			//line 32 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			while (( _g1 < _g ))
			{
				//line 32 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				int i = _g1++;
				//line 33 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				((int[]) (this.data_) )[i] += ((int[]) (v.data_) )[i];
			}
			
		}
		
	}
	
	
	public int kDataSize;
	
	public int[] data_;
	
	public int total_count_;
	
	public double bit_cost_;
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		{
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			switch (field.hashCode())
			{
				case -39555968:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("bit_cost_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.bit_cost_ = ((double) (value) );
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return value;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 1729570902:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("kDataSize")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.kDataSize = ((int) (value) );
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return value;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 244285067:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("total_count_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.total_count_ = ((int) (value) );
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return value;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
			}
			
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		{
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			switch (field.hashCode())
			{
				case -39555968:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("bit_cost_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.bit_cost_ = ((double) (haxe.lang.Runtime.toDouble(value)) );
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return value;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 1729570902:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("kDataSize")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.kDataSize = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return value;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 244285067:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("total_count_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.total_count_ = ((int) (haxe.lang.Runtime.toInt(value)) );
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return value;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 95356405:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("data_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.data_ = ((int[]) (value) );
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return value;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
			}
			
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		{
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			switch (field.hashCode())
			{
				case -39555968:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("bit_cost_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return this.bit_cost_;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 65193517:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("Clear")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Clear")) );
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 244285067:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("total_count_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return this.total_count_;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 2035664:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("Add1")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Add1")) );
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 95356405:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("data_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return this.data_;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case -1850743644:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("Remove")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Remove")) );
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 1729570902:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("kDataSize")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return this.kDataSize;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 2035665:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("Add2")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "Add2")) );
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 1751589347:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("AddHistogram")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return ((haxe.lang.Function) (new haxe.lang.Closure(this, "AddHistogram")) );
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
			}
			
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		{
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			switch (field.hashCode())
			{
				case -39555968:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("bit_cost_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return this.bit_cost_;
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 1729570902:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("kDataSize")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return ((double) (this.kDataSize) );
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 244285067:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("total_count_")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						return ((double) (this.total_count_) );
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
			}
			
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, haxe.root.Array dynargs)
	{
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		{
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			switch (field.hashCode())
			{
				case 1751589347:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("AddHistogram")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.AddHistogram(((encode.histogram.Histogram) (dynargs.__get(0)) ));
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 65193517:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("Clear")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.Clear();
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 2035665:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("Add2")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.Add2(((haxe.root.Array<java.lang.Object>) (dynargs.__get(0)) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(1))) ), ((int) (haxe.lang.Runtime.toInt(dynargs.__get(2))) ));
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case 2035664:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("Add1")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.Add1(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ));
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
				case -1850743644:
				{
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					if (field.equals("Remove")) 
					{
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						__temp_executeDef1 = false;
						//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
						this.Remove(((int) (haxe.lang.Runtime.toInt(dynargs.__get(0))) ));
					}
					
					//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
					break;
				}
				
				
			}
			
			//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		baseArr.push("bit_cost_");
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		baseArr.push("total_count_");
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		baseArr.push("data_");
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		baseArr.push("kDataSize");
		//line 9 "C:\\Users\\Dominik\\Brotli\\src\\encode\\histogram\\Histogram.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}

