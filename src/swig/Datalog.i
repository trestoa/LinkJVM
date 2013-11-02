/*
* This file is part of LinkJVM.
*
* Java Framework for the KIPR Link
* Copyright (C) 2013 Markus Klein <m@mklein.co.at>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

%module linkjvm_datalog
%{
    #include <string>
    #include <vector>
    #include <map>
}

%include "stl.i"

class  Category{
	public:
        void append(const std::string& data);
        void append(const double& data);

        void remove(const unsigned int& index);
        const std::vector<std::string>& entries() const;
        const std::string& name() const;

        friend class DataLog;
	private:
        Category(const std::string& name);

        std::string m_name;
        std::vector<std::string> m_entries;
};

class  DataLogWriter{
	public:
        virtual ~DataLogWriter();

        virtual bool write(const DataLog *dataLog) = 0;
};

class  CsvWriter : public DataLogWriter{
	public:
        CsvWriter(const std::string& path);
        virtual bool write(const DataLog *dataLog);

	private:
        std::string m_path;
};

class  PlainWriter : public DataLogWriter{
	public:
        PlainWriter(const std::string& path);
        virtual bool write(const DataLog *dataLog);
	private:
        unsigned int columnWidth(Category *category) const;

        std::string m_path;
};

class  DataLog{
	public:
        ~DataLog();
        Category *category(const std::string& name);
        void removeCategory(const std::string& name);
        std::vector<Category *> categories() const;
        bool write(DataLogWriter *writer) const;
        void clear();
	private:
        std::map<std::string, Category *> m_categories;
};