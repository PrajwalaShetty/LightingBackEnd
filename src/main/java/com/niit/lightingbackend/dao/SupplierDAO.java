package com.niit.lightingbackend.dao;

import java.util.List;

import com.niit.lightingbackend.model.Supplier;
public interface SupplierDAO {

	public List<SupplierDAO> list();

	public Supplier get(int supplierid);

	public void save(Supplier reg);

	public void update(Supplier supplier);

	public void delete(int supplierid);
}
