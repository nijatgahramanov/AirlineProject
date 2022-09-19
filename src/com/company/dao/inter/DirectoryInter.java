package com.company.dao.inter;

import com.company.entity.Directory;

import java.util.List;

public interface DirectoryInter {
    public boolean addDirectory(Directory directory);
    public Directory getByDirectoryId(Integer id);
    public List<Directory> getAllDirectory();
}
