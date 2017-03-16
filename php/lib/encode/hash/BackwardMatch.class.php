<?php

// Generated by Haxe 3.4.0
class encode_hash_BackwardMatch {
	public function __construct() {}
	public function BackwardMatch0() {
		$this->distance = 0;
		$this->length_and_code = 0;
	}
	public function BackwardMatch2($dist, $len) {
		$this->distance = $dist;
		$this->length_and_code = $len << 5;
	}
	public function BackwardMatch3($dist, $len, $len_code) {
		$this->distance = $dist;
		$tmp = null;
		if($len === $len_code) {
			$tmp = 0;
		} else {
			$tmp = $len_code;
		}
		$this->length_and_code = $len << 5 | $tmp;
	}
	public function length() {
		return $this->length_and_code >> 5;
	}
	public function length_code() {
		$code = $this->length_and_code & 31;
		if($code > 0) {
			return $code;
		} else {
			return $this->length();
		}
	}
	public $distance;
	public $length_and_code;
	public function __call($m, $a) {
		if(isset($this->$m) && is_callable($this->$m))
			return call_user_func_array($this->$m, $a);
		else if(isset($this->__dynamics[$m]) && is_callable($this->__dynamics[$m]))
			return call_user_func_array($this->__dynamics[$m], $a);
		else if('toString' == $m)
			return $this->__toString();
		else
			throw new HException('Unable to call <'.$m.'>');
	}
	function __toString() { return 'encode.hash.BackwardMatch'; }
}