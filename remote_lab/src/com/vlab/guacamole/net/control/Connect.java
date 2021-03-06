package com.vlab.guacamole.net.control;

/*
 *  Guacamole - Pure JavaScript/HTML VNC Client
 *  Copyright (C) 2010  Michael Jumper
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import javax.servlet.ServletRequest;

import org.w3c.dom.Element;

import com.vlab.guacamole.net.XMLGuacamoleServlet;
import com.vlab.guacamole.GuacamoleException;
import com.vlab.guacamole.net.GuacamoleSession;

public class Connect extends XMLGuacamoleServlet {
   
    protected boolean shouldCreateSession() {
        return true;
    }

    @Override
    protected void handleRequest(GuacamoleSession session, ServletRequest request, Element root) throws GuacamoleException {

        try {
            session.connect();
        }
        catch (GuacamoleException e) {
            throw new GuacamoleException("Error connecting to server: " + e.getMessage(), e);
        }

    } 

}
