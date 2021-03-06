// Generated by Haxe 3.4.0

#pragma warning disable 109, 114, 219, 429, 168, 162
namespace encode.backward_references {
	public class ZopfliCostModel : global::haxe.lang.HxObject {
		
		public ZopfliCostModel(global::haxe.lang.EmptyObject empty) {
		}
		
		
		public ZopfliCostModel() {
			global::encode.backward_references.ZopfliCostModel.__hx_ctor_encode_backward_references_ZopfliCostModel(this);
		}
		
		
		public static void __hx_ctor_encode_backward_references_ZopfliCostModel(global::encode.backward_references.ZopfliCostModel __hx_this) {
		}
		
		
		public virtual void SetFromCommands(int num_bytes, int position, uint[] ringbuffer, int ringbuffer_mask, global::Array<object> commands, int num_commands, int last_insert_len) {
			unchecked {
				int[] histogram_literal = global::FunctionMalloc.mallocInt(256);
				int[] histogram_cmd = global::FunctionMalloc.mallocInt(704);
				int[] histogram_dist = global::FunctionMalloc.mallocInt(520);
				int pos = ( position - last_insert_len );
				{
					int _g1 = 0;
					while (( _g1 < num_commands )) {
						int i = _g1++;
						int inslength = ((global::encode.command.Command) (commands[i]) ).insert_len_;
						int copylength = ((global::encode.command.Command) (commands[i]) ).copy_len_;
						int distcode = ((int) (((global::encode.command.Command) (commands[i]) ).dist_prefix_[0]) );
						int cmdcode = ((int) (((global::encode.command.Command) (commands[i]) ).cmd_prefix_[0]) );
						((int[]) (histogram_cmd) )[cmdcode] = ( ((int) (((int[]) (histogram_cmd) )[cmdcode]) ) + 1 );
						if (( cmdcode >= 128 )) {
							((int[]) (histogram_dist) )[distcode] = ( ((int) (((int[]) (histogram_dist) )[distcode]) ) + 1 );
						}
						
						{
							int _g3 = 0;
							while (( _g3 < inslength )) {
								uint _g4 = ((uint) (((uint[]) (ringbuffer) )[( ( pos + _g3++ ) & ringbuffer_mask )]) );
								((int[]) (histogram_literal) )[((int) (_g4) )] = ( ((int) (((int[]) (histogram_literal) )[((int) (_g4) )]) ) + 1 );
							}
							
						}
						
						pos += ( inslength + copylength );
					}
					
				}
				
				global::Array<object> cost_literal_ = new global::Array<object>();
				this.Set(histogram_literal, cost_literal_);
				double[] cost_literal = ((double[]) (cost_literal_[0]) );
				global::Array<object> cost_cmd = new global::Array<object>(new object[]{this.cost_cmd_});
				this.Set(histogram_cmd, cost_cmd);
				this.cost_cmd_ = ((double[]) (cost_cmd[0]) );
				global::Array<object> cost_dist = new global::Array<object>(new object[]{this.cost_dist_});
				this.Set(histogram_dist, cost_dist);
				this.cost_dist_ = ((double[]) (cost_dist[0]) );
				this.min_cost_cmd_ = global::encode.Backward_references.kInfinity;
				{
					int _g = 0;
					while (( _g < 704 )) {
						this.min_cost_cmd_ = global::System.Math.Min(((double) (this.min_cost_cmd_) ), ((double) (((double[]) (this.cost_cmd_) )[_g++]) ));
					}
					
				}
				
				this.literal_costs_ = ((double[]) (new double[( num_bytes + 1 )]) );
				((double[]) (this.literal_costs_) )[0] = 0.0;
				{
					int _g11 = 0;
					while (( _g11 < num_bytes )) {
						int i1 = _g11++;
						((double[]) (this.literal_costs_) )[( i1 + 1 )] = ( ((double[]) (this.literal_costs_) )[i1] + ((double) (((double[]) (cost_literal) )[((int) (((uint) (((uint[]) (ringbuffer) )[( ( position + i1 ) & ringbuffer_mask )]) )) )]) ) );
					}
					
				}
				
			}
		}
		
		
		public virtual void SetFromLiteralCosts(int num_bytes, int position, double[] literal_cost, int literal_cost_mask) {
			unchecked {
				this.literal_costs_ = global::FunctionMalloc.mallocFloat(( num_bytes + 1 ));
				((double[]) (this.literal_costs_) )[0] = 0.0;
				if (( literal_cost != null )) {
					int _g1 = 0;
					while (( _g1 < num_bytes )) {
						int i = _g1++;
						((double[]) (this.literal_costs_) )[( i + 1 )] = ( ((double[]) (this.literal_costs_) )[i] + ((double) (((double[]) (literal_cost) )[( ( position + i ) & literal_cost_mask )]) ) );
					}
					
				}
				else {
					int _g11 = 1;
					int _g = ( num_bytes + 1 );
					while (( _g11 < _g )) {
						int i1 = _g11++;
						((double[]) (this.literal_costs_) )[i1] = ( i1 * 5.4 );
					}
					
				}
				
				this.cost_cmd_ = ((double[]) (new double[704]) );
				this.cost_dist_ = ((double[]) (new double[520]) );
				{
					int _g2 = 0;
					while (( _g2 < 704 )) {
						int i2 = _g2++;
						((double[]) (this.cost_cmd_) )[i2] = global::encode.Fast_log.FastLog2(( 11 + i2 ));
					}
					
				}
				
				{
					int _g3 = 0;
					while (( _g3 < 520 )) {
						int i3 = _g3++;
						((double[]) (this.cost_dist_) )[i3] = global::encode.Fast_log.FastLog2(( 20 + i3 ));
					}
					
				}
				
				this.min_cost_cmd_ = global::encode.Fast_log.FastLog2(11);
			}
		}
		
		
		public virtual double GetCommandCost(int dist_code, int length_code, int insert_length) {
			unchecked {
				int inscode = global::encode.Command_functions.GetInsertLengthCode(insert_length);
				int copycode = global::encode.Command_functions.GetCopyLengthCode(length_code);
				uint cmdcode = ((uint) (global::encode.Command_functions.CombineLengthCodes(inscode, copycode, dist_code)) );
				uint insnumextra = ((uint) (global::encode.Command_functions.insextra[inscode]) );
				uint copynumextra = ((uint) (global::encode.Command_functions.copyextra[copycode]) );
				global::Array<uint> dist_symbol = new global::Array<uint>();
				global::Array<uint> distextra = new global::Array<uint>();
				global::encode.Command_functions.GetDistCode(dist_code, dist_symbol, distextra);
				double result = ((double) (((uint) (( ((uint) (( insnumextra + copynumextra )) ) + (((uint) (((uint) (( ((uint) (distextra[0]) ) >> 24 )) )) )) )) )) );
				result += ((double[]) (this.cost_cmd_) )[((int) (cmdcode) )];
				if (((bool) (( cmdcode >= 128 )) )) {
					result += ((double[]) (this.cost_dist_) )[((int) (dist_symbol[0]) )];
				}
				
				return result;
			}
		}
		
		
		public virtual double GetLiteralCosts(int @from, int to) {
			return ( ((double[]) (this.literal_costs_) )[to] - ((double[]) (this.literal_costs_) )[@from] );
		}
		
		
		public virtual double GetMinCostCmd() {
			return this.min_cost_cmd_;
		}
		
		
		public virtual void Set(int[] histogram, global::Array<object> cost) {
			unchecked {
				cost[0] = ((double[]) (new double[( ((int[]) (histogram) ) as global::System.Array ).Length]) );
				int sum = 0;
				{
					int _g1 = 0;
					int _g = ( ((int[]) (histogram) ) as global::System.Array ).Length;
					while (( _g1 < _g )) {
						sum += ((int) (((int[]) (histogram) )[_g1++]) );
					}
					
				}
				
				double log2sum = global::encode.Fast_log.FastLog2(sum);
				{
					int _g11 = 0;
					int _g2 = ( ((int[]) (histogram) ) as global::System.Array ).Length;
					while (( _g11 < _g2 )) {
						int i = _g11++;
						if (( ((int) (((int[]) (histogram) )[i]) ) == 0 )) {
							((double[]) (cost[0]) )[i] = ( log2sum + 2 );
							continue;
						}
						
						{
							double val = ( log2sum - global::encode.Fast_log.FastLog2(((int) (((int[]) (histogram) )[i]) )) );
							((double[]) (cost[0]) )[i] = val;
						}
						
						if (( ((double) (((double[]) (cost[0]) )[i]) ) < 1 )) {
							((double[]) (cost[0]) )[i] = ((double) (1) );
						}
						
					}
					
				}
				
			}
		}
		
		
		public double[] cost_cmd_;
		
		public double[] cost_dist_;
		
		public double[] literal_costs_;
		
		public double min_cost_cmd_;
		
		public override double __hx_setField_f(string field, int hash, double @value, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 1246202602:
					{
						this.min_cost_cmd_ = ((double) (@value) );
						return @value;
					}
					
					
					default:
					{
						return base.__hx_setField_f(field, hash, @value, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_setField(string field, int hash, object @value, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 1246202602:
					{
						this.min_cost_cmd_ = ((double) (global::haxe.lang.Runtime.toDouble(@value)) );
						return @value;
					}
					
					
					case 1226642473:
					{
						this.literal_costs_ = ((double[]) (@value) );
						return @value;
					}
					
					
					case 848580487:
					{
						this.cost_dist_ = ((double[]) (@value) );
						return @value;
					}
					
					
					case 1687786263:
					{
						this.cost_cmd_ = ((double[]) (@value) );
						return @value;
					}
					
					
					default:
					{
						return base.__hx_setField(field, hash, @value, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_getField(string field, int hash, bool throwErrors, bool isCheck, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 1246202602:
					{
						return this.min_cost_cmd_;
					}
					
					
					case 1226642473:
					{
						return this.literal_costs_;
					}
					
					
					case 848580487:
					{
						return this.cost_dist_;
					}
					
					
					case 1687786263:
					{
						return this.cost_cmd_;
					}
					
					
					case 4150146:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "Set", 4150146)) );
					}
					
					
					case 1685626577:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "GetMinCostCmd", 1685626577)) );
					}
					
					
					case 1017272109:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "GetLiteralCosts", 1017272109)) );
					}
					
					
					case 286868578:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "GetCommandCost", 286868578)) );
					}
					
					
					case 666449347:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "SetFromLiteralCosts", 666449347)) );
					}
					
					
					case 1571710708:
					{
						return ((global::haxe.lang.Function) (new global::haxe.lang.Closure(this, "SetFromCommands", 1571710708)) );
					}
					
					
					default:
					{
						return base.__hx_getField(field, hash, throwErrors, isCheck, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override double __hx_getField_f(string field, int hash, bool throwErrors, bool handleProperties) {
			unchecked {
				switch (hash) {
					case 1246202602:
					{
						return this.min_cost_cmd_;
					}
					
					
					default:
					{
						return base.__hx_getField_f(field, hash, throwErrors, handleProperties);
					}
					
				}
				
			}
		}
		
		
		public override object __hx_invokeField(string field, int hash, global::Array dynargs) {
			unchecked {
				switch (hash) {
					case 4150146:
					{
						this.Set(((int[]) (dynargs[0]) ), ((global::Array<object>) (global::Array<object>.__hx_cast<object>(((global::Array) (dynargs[1]) ))) ));
						break;
					}
					
					
					case 1685626577:
					{
						return this.GetMinCostCmd();
					}
					
					
					case 1017272109:
					{
						return this.GetLiteralCosts(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[1])) ));
					}
					
					
					case 286868578:
					{
						return this.GetCommandCost(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[1])) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[2])) ));
					}
					
					
					case 666449347:
					{
						this.SetFromLiteralCosts(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[1])) ), ((double[]) (dynargs[2]) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[3])) ));
						break;
					}
					
					
					case 1571710708:
					{
						this.SetFromCommands(((int) (global::haxe.lang.Runtime.toInt(dynargs[0])) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[1])) ), ((uint[]) (dynargs[2]) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[3])) ), ((global::Array<object>) (global::Array<object>.__hx_cast<object>(((global::Array) (dynargs[4]) ))) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[5])) ), ((int) (global::haxe.lang.Runtime.toInt(dynargs[6])) ));
						break;
					}
					
					
					default:
					{
						return base.__hx_invokeField(field, hash, dynargs);
					}
					
				}
				
				return null;
			}
		}
		
		
		public override void __hx_getFields(global::Array<object> baseArr) {
			baseArr.push("min_cost_cmd_");
			baseArr.push("literal_costs_");
			baseArr.push("cost_dist_");
			baseArr.push("cost_cmd_");
			base.__hx_getFields(baseArr);
		}
		
		
	}
}


