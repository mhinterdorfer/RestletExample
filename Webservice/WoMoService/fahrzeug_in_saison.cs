//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WoMoService
{
    using System;
    using System.Collections.Generic;
    
    public partial class fahrzeug_in_saison
    {
        public int IdSaison { get; set; }
        public int fahrgestellNr { get; set; }
        public Nullable<double> tagespreis { get; set; }
    
        public virtual Fahrzeug Fahrzeug { get; set; }
        public virtual Saison Saison { get; set; }
    }
}
