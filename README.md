Vinitello Dux
===========
A RuneScape emulation API following in Java designed to improve production activity of RuneScape emulators.

Modularity
----------
Vinitello is highly modular. Thanks to Google Guice, it's possible to quickly swap implementation modules
that use a high-level well-defined interface. Google Guice also allows us to provide easy configuration
of modules, even allowing configuration to existing libraries that use well-defined interfaces.

Networking
----------
We are planning to provide an implementation of JBoss Netty, Apache MINA 2, and Java IO. Your choice of
networking implementation is quick to swap using Google Guice.

Licensing
----------
Vinitello is released open-source under the MIT license.