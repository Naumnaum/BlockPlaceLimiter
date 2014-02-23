package io.github.naumnaum.BlockPlaceLimiter;

import org.bukkit.block.Block;

public class BPLBlock {

	private int id;
	private byte meta;
	private String name;
	
	@SuppressWarnings("deprecation")
	public BPLBlock(Block b){
		id = b.getTypeId();
		meta = b.getData();
		name = b.getType().name().toLowerCase().replace('_', ' ');
	}
	
	public BPLBlock(int id, byte meta, String name){
		this.id=id;
		this.meta=meta;
		this.name=name;
	}
	
	public boolean equals(BPLBlock b){
		if (this.id==b.id && this.meta==b.meta)
			return true;
		return false;
	}
	
	public String toString(){
		return "Id: "+id+" Meta: "+meta+" Name: "+name;
	}
	
	public static BPLBlock parseConfig(String s){
		int id = Integer.parseInt(s.trim().split(":")[0].trim());
		byte meta = Byte.parseByte(s.trim().split(":")[1].trim().split("=")[0].trim());
		return new BPLBlock(id, meta, "config");
	}
}
