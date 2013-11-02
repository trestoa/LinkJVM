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

%module linkjvm_config

%include "stl.i"

class Config
{
    public:
        Config();
        Config(const std::map<std::string, std::string> &config);

        static Config *load(const std::string &path);
        bool save(const std::string &path) const;

        void beginGroup(const std::string &group);
        void endGroup();
        void clearGroup();

        void clear();

        bool containsKey(const std::string &key) const;

        bool boolValue(const std::string &key) const;
        int intValue(const std::string &key) const;
        double doubleValue(const std::string &key) const;
        std::string stringValue(const std::string &key) const;

        void setValue(const std::string &key, const bool &value);
        void setValue(const std::string &key, const int &value);
        void setValue(const std::string &key, const double &value);
        void setValue(const std::string &key, const char *value);
        void setValue(const std::string &key, const std::string &value);

        Config values() const;
        void addValues(const Config &config);

    private:
        std::string safeKey(std::string key) const;
        std::string group() const;

        std::map<std::string, std::string> m_config;
        std::vector<std::string> m_groups;
        mutable std::string m_cachedGroup;
};
