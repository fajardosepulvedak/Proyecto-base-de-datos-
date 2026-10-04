--
-- PostgreSQL database dump
--

\restrict luTagFXpEBX8fs3A7hz3tXoKNpSVd8vY6W7dcLAaJU4HYfx11yNfVj8KGWqdznr

-- Dumped from database version 18.0
-- Dumped by pg_dump version 18.0

-- Started on 2025-11-21 15:57:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5005 (class 1262 OID 16826)
-- Name: empleados_en_casa; Type: DATABASE; Schema: -; Owner: kevin
--

CREATE DATABASE empleados_en_casa WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_United States.1252';


ALTER DATABASE empleados_en_casa OWNER TO kevin;

\unrestrict luTagFXpEBX8fs3A7hz3tXoKNpSVd8vY6W7dcLAaJU4HYfx11yNfVj8KGWqdznr
\connect empleados_en_casa
\restrict luTagFXpEBX8fs3A7hz3tXoKNpSVd8vY6W7dcLAaJU4HYfx11yNfVj8KGWqdznr

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 5006 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 227 (class 1259 OID 16861)
-- Name: addresses; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.addresses (
    address_id integer NOT NULL,
    line_1 character varying(150) NOT NULL,
    line_2 character varying(150),
    line_3 character varying(150),
    town_city character varying(100) NOT NULL,
    state_province character varying(100),
    country_code character varying(10) NOT NULL
);


ALTER TABLE public.addresses OWNER TO kevin;

--
-- TOC entry 226 (class 1259 OID 16860)
-- Name: addresses_address_id_seq; Type: SEQUENCE; Schema: public; Owner: kevin
--

CREATE SEQUENCE public.addresses_address_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.addresses_address_id_seq OWNER TO kevin;

--
-- TOC entry 5007 (class 0 OID 0)
-- Dependencies: 226
-- Name: addresses_address_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kevin
--

ALTER SEQUENCE public.addresses_address_id_seq OWNED BY public.addresses.address_id;


--
-- TOC entry 230 (class 1259 OID 16888)
-- Name: employee_addresses; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.employee_addresses (
    date_address_from date NOT NULL,
    date_address_to date,
    employee_id integer NOT NULL,
    address_id integer NOT NULL
);


ALTER TABLE public.employee_addresses OWNER TO kevin;

--
-- TOC entry 234 (class 1259 OID 16997)
-- Name: employee_on_projects; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.employee_on_projects (
    employee_on_project_period_id integer NOT NULL,
    hourly_rate numeric(10,2) NOT NULL,
    hours_allocated integer NOT NULL,
    performance_notes text NOT NULL,
    project_id integer,
    employee_id integer,
    from_day_date date,
    to_day_date date,
    staff_id integer
);


ALTER TABLE public.employee_on_projects OWNER TO kevin;

--
-- TOC entry 233 (class 1259 OID 16996)
-- Name: employee_on_projects_employee_on_project_period_id_seq; Type: SEQUENCE; Schema: public; Owner: kevin
--

CREATE SEQUENCE public.employee_on_projects_employee_on_project_period_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.employee_on_projects_employee_on_project_period_id_seq OWNER TO kevin;

--
-- TOC entry 5008 (class 0 OID 0)
-- Dependencies: 233
-- Name: employee_on_projects_employee_on_project_period_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kevin
--

ALTER SEQUENCE public.employee_on_projects_employee_on_project_period_id_seq OWNED BY public.employee_on_projects.employee_on_project_period_id;


--
-- TOC entry 235 (class 1259 OID 17024)
-- Name: employee_skills; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.employee_skills (
    employee_id integer NOT NULL,
    skill_code integer NOT NULL,
    skill_level_code integer
);


ALTER TABLE public.employee_skills OWNER TO kevin;

--
-- TOC entry 229 (class 1259 OID 16872)
-- Name: employees; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.employees (
    employee_id integer NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    date_of_birth date,
    hire_date date,
    salary numeric(10,2),
    email character varying(100),
    phone_number character varying(20),
    role_code integer,
    supervisor_id integer
);


ALTER TABLE public.employees OWNER TO kevin;

--
-- TOC entry 228 (class 1259 OID 16871)
-- Name: employees_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: kevin
--

CREATE SEQUENCE public.employees_employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.employees_employee_id_seq OWNER TO kevin;

--
-- TOC entry 5009 (class 0 OID 0)
-- Dependencies: 228
-- Name: employees_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kevin
--

ALTER SEQUENCE public.employees_employee_id_seq OWNED BY public.employees.employee_id;


--
-- TOC entry 232 (class 1259 OID 16907)
-- Name: projects; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.projects (
    project_id integer NOT NULL,
    client_id integer,
    project_name character varying(100) NOT NULL,
    project_start_date date,
    project_end_date date,
    project_status character varying(50),
    project_budget numeric(12,2),
    project_description text
);


ALTER TABLE public.projects OWNER TO kevin;

--
-- TOC entry 231 (class 1259 OID 16906)
-- Name: projects_project_id_seq; Type: SEQUENCE; Schema: public; Owner: kevin
--

CREATE SEQUENCE public.projects_project_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.projects_project_id_seq OWNER TO kevin;

--
-- TOC entry 5010 (class 0 OID 0)
-- Dependencies: 231
-- Name: projects_project_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kevin
--

ALTER SEQUENCE public.projects_project_id_seq OWNED BY public.projects.project_id;


--
-- TOC entry 225 (class 1259 OID 16854)
-- Name: ref_calendar; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.ref_calendar (
    day_date date NOT NULL,
    business_day_yn boolean,
    day_number integer,
    period_id integer,
    day_name character varying(20)
);


ALTER TABLE public.ref_calendar OWNER TO kevin;

--
-- TOC entry 220 (class 1259 OID 16828)
-- Name: ref_roles; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.ref_roles (
    role_code integer NOT NULL,
    role_name character varying(100) NOT NULL
);


ALTER TABLE public.ref_roles OWNER TO kevin;

--
-- TOC entry 219 (class 1259 OID 16827)
-- Name: ref_roles_role_code_seq; Type: SEQUENCE; Schema: public; Owner: kevin
--

CREATE SEQUENCE public.ref_roles_role_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ref_roles_role_code_seq OWNER TO kevin;

--
-- TOC entry 5011 (class 0 OID 0)
-- Dependencies: 219
-- Name: ref_roles_role_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kevin
--

ALTER SEQUENCE public.ref_roles_role_code_seq OWNED BY public.ref_roles.role_code;


--
-- TOC entry 222 (class 1259 OID 16837)
-- Name: ref_skill_levels; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.ref_skill_levels (
    skill_level_code integer NOT NULL,
    skill_level_name character varying(50) NOT NULL,
    experience_required_years integer
);


ALTER TABLE public.ref_skill_levels OWNER TO kevin;

--
-- TOC entry 221 (class 1259 OID 16836)
-- Name: ref_skill_levels_skill_level_code_seq; Type: SEQUENCE; Schema: public; Owner: kevin
--

CREATE SEQUENCE public.ref_skill_levels_skill_level_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ref_skill_levels_skill_level_code_seq OWNER TO kevin;

--
-- TOC entry 5012 (class 0 OID 0)
-- Dependencies: 221
-- Name: ref_skill_levels_skill_level_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kevin
--

ALTER SEQUENCE public.ref_skill_levels_skill_level_code_seq OWNED BY public.ref_skill_levels.skill_level_code;


--
-- TOC entry 224 (class 1259 OID 16846)
-- Name: ref_skills; Type: TABLE; Schema: public; Owner: kevin
--

CREATE TABLE public.ref_skills (
    skill_code integer NOT NULL,
    skill_name character varying(100) NOT NULL,
    skill_category character varying(100)
);


ALTER TABLE public.ref_skills OWNER TO kevin;

--
-- TOC entry 223 (class 1259 OID 16845)
-- Name: ref_skills_skill_code_seq; Type: SEQUENCE; Schema: public; Owner: kevin
--

CREATE SEQUENCE public.ref_skills_skill_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ref_skills_skill_code_seq OWNER TO kevin;

--
-- TOC entry 5013 (class 0 OID 0)
-- Dependencies: 223
-- Name: ref_skills_skill_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kevin
--

ALTER SEQUENCE public.ref_skills_skill_code_seq OWNED BY public.ref_skills.skill_code;


--
-- TOC entry 4800 (class 2604 OID 17051)
-- Name: addresses address_id; Type: DEFAULT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.addresses ALTER COLUMN address_id SET DEFAULT nextval('public.addresses_address_id_seq'::regclass);


--
-- TOC entry 4803 (class 2604 OID 17052)
-- Name: employee_on_projects employee_on_project_period_id; Type: DEFAULT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_on_projects ALTER COLUMN employee_on_project_period_id SET DEFAULT nextval('public.employee_on_projects_employee_on_project_period_id_seq'::regclass);


--
-- TOC entry 4801 (class 2604 OID 17053)
-- Name: employees employee_id; Type: DEFAULT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employees ALTER COLUMN employee_id SET DEFAULT nextval('public.employees_employee_id_seq'::regclass);


--
-- TOC entry 4802 (class 2604 OID 17054)
-- Name: projects project_id; Type: DEFAULT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.projects ALTER COLUMN project_id SET DEFAULT nextval('public.projects_project_id_seq'::regclass);


--
-- TOC entry 4797 (class 2604 OID 17055)
-- Name: ref_roles role_code; Type: DEFAULT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.ref_roles ALTER COLUMN role_code SET DEFAULT nextval('public.ref_roles_role_code_seq'::regclass);


--
-- TOC entry 4798 (class 2604 OID 17056)
-- Name: ref_skill_levels skill_level_code; Type: DEFAULT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.ref_skill_levels ALTER COLUMN skill_level_code SET DEFAULT nextval('public.ref_skill_levels_skill_level_code_seq'::regclass);


--
-- TOC entry 4799 (class 2604 OID 17057)
-- Name: ref_skills skill_code; Type: DEFAULT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.ref_skills ALTER COLUMN skill_code SET DEFAULT nextval('public.ref_skills_skill_code_seq'::regclass);


--
-- TOC entry 4991 (class 0 OID 16861)
-- Dependencies: 227
-- Data for Name: addresses; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.addresses (address_id, line_1, line_2, line_3, town_city, state_province, country_code) FROM stdin;
1	123 Main Street	Apt 4B	\N	New York	NY	US
2	456 Oak Avenue	\N	\N	Los Angeles	CA	US
3	789 Pine Road	Suite 200	Building C	Chicago	IL	US
4	321 Elm Street	\N	\N	Houston	TX	US
5	654 Maple Drive	Floor 3	\N	Phoenix	AZ	US
6	987 Cedar Lane	Apt 12	\N	Philadelphia	PA	US
7	159 Birch Boulevard	\N	\N	San Antonio	TX	US
8	753 Willow Way	Unit 5	\N	San Diego	CA	US
9	246 Spruce Circle	Suite 100	\N	Dallas	TX	US
10	135 Aspen Trail	\N	\N	San Jose	CA	US
11	864 Magnolia Street	Apt 7C	\N	Austin	TX	US
12	579 Cypress Avenue	Floor 2	Office B	Jacksonville	FL	US
13	792 Redwood Road	\N	\N	Fort Worth	TX	US
14	681 Palm Drive	Suite 300	\N	Columbus	OH	US
15	423 Sequoia Lane	Apt 22	\N	Charlotte	NC	US
16	954 Fir Street	\N	\N	San Francisco	CA	US
17	267 Hemlock Way	Unit 15	\N	Indianapolis	IN	US
18	738 Poplar Avenue	Floor 5	\N	Seattle	WA	US
19	519 Sycamore Road	Apt 9D	\N	Denver	CO	US
20	384 Chestnut Circle	\N	\N	Washington	DC	US
\.


--
-- TOC entry 4994 (class 0 OID 16888)
-- Dependencies: 230
-- Data for Name: employee_addresses; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.employee_addresses (date_address_from, date_address_to, employee_id, address_id) FROM stdin;
2024-01-15	2024-01-31	1	1
2024-01-16	2024-02-01	2	2
2024-01-18	2024-02-03	4	4
2024-01-19	2024-01-31	5	5
2024-01-20	2024-02-01	6	6
2024-01-22	2024-02-03	8	8
2024-01-23	2024-01-31	9	9
2024-01-24	2024-02-01	10	10
2024-01-25	2024-02-02	11	11
2024-01-26	2024-02-03	12	12
2024-01-27	2024-01-31	13	13
2024-01-28	2024-02-01	14	14
2024-01-30	2024-02-03	16	16
2024-01-31	2024-02-01	17	17
2024-02-01	2024-02-02	18	18
2024-02-02	2024-02-03	19	19
\.


--
-- TOC entry 4998 (class 0 OID 16997)
-- Dependencies: 234
-- Data for Name: employee_on_projects; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.employee_on_projects (employee_on_project_period_id, hourly_rate, hours_allocated, performance_notes, project_id, employee_id, from_day_date, to_day_date, staff_id) FROM stdin;
81	45.00	20	Excellent performance on frontend development	1	1	2024-01-15	2024-01-16	2
82	35.00	25	Strong backend skills, quick learner	1	2	2024-01-17	2024-01-18	3
83	55.00	30	Leading mobile app development team	2	3	2024-01-19	2024-01-22	4
84	40.00	35	Great UI/UX implementation	2	4	2024-01-23	2024-01-24	5
85	65.00	40	Successfully delivered CRM project on time	3	5	2024-01-25	2024-01-26	6
86	50.00	25	Efficient data migration execution	4	6	2024-01-29	2024-01-30	7
87	70.00	35	Architecting e-commerce platform	5	7	2024-01-31	2024-02-01	8
88	30.00	20	Junior developer showing great potential	5	8	2024-02-02	2024-02-03	9
89	42.00	15	Strong SEO analysis skills	6	9	2024-01-15	2024-01-16	10
90	75.00	40	Cloud migration completed successfully	7	10	2024-01-17	2024-01-18	11
91	48.00	30	Payment integration expertise	8	11	2024-01-19	2024-01-22	12
92	32.00	25	Learning AI technologies quickly	9	12	2024-01-23	2024-01-24	13
93	45.00	35	API development progressing well	10	13	2024-01-25	2024-01-26	14
94	60.00	20	Security audit completed thoroughly	11	14	2024-01-29	2024-01-30	15
95	38.00	30	Dashboard design meeting expectations	12	15	2024-01-31	2024-02-01	16
96	52.00	25	Training portal delivered successfully	13	16	2024-02-02	2024-02-03	17
97	68.00	40	IoT solution architecture in progress	14	17	2024-01-15	2024-01-16	18
98	44.00	35	Blockchain prototype development	15	18	2024-01-17	2024-01-18	19
99	58.00	30	VR application design and development	16	19	2024-01-19	2024-01-22	20
100	46.00	20	Disaster recovery plan implemented	17	20	2024-01-23	2024-01-24	1
\.


--
-- TOC entry 4999 (class 0 OID 17024)
-- Dependencies: 235
-- Data for Name: employee_skills; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.employee_skills (employee_id, skill_code, skill_level_code) FROM stdin;
1	1	6
1	2	5
2	2	7
2	3	6
4	6	6
4	7	5
5	8	9
5	9	8
6	10	4
6	11	5
8	14	3
8	15	4
9	16	8
9	17	7
10	18	6
10	19	5
11	20	4
11	1	3
12	2	7
12	3	6
13	4	5
13	5	4
14	6	8
14	7	7
16	10	9
16	11	8
17	12	7
17	13	6
18	14	5
18	15	4
19	16	8
19	17	7
\.


--
-- TOC entry 4993 (class 0 OID 16872)
-- Dependencies: 229
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.employees (employee_id, first_name, last_name, date_of_birth, hire_date, salary, email, phone_number, role_code, supervisor_id) FROM stdin;
82	Juan	Lopez	1986-10-08	2020-10-16	80000.00			1	1
85	Juan	Hernandez	2005-12-10	2020-10-12	45000.00	asdsad	24234234	11	\N
10	Amanda	Taylor	1989-05-03	2021-04-18	67000.00	amanda.taylor@company.com	+1-555-0110	10	\N
11	Christopher	Anderson	1994-01-12	2022-09-10	51000.00	christopher.anderson@company.com	+1-555-0111	11	\N
12	Michelle	Thomas	1986-10-08	2019-12-03	78000.00	michelle.thomas@company.com	+1-555-0112	12	\N
17	Brian	Thompson	1988-09-15	2021-08-07	73000.00	brian.thompson@company.com	+1-555-0117	17	\N
18	Nicole	Gonzalez	1993-06-24	2022-11-20	59000.00	nicole.gonzalez@company.com	+1-555-0118	18	\N
1	John	Smith	1985-03-15	2020-01-10	75000.00	john.smith@company.com	+1-555-0101	1	\N
2	Maria	Garcia	1990-07-22	2021-03-15	68000.00	maria.garcia@company.com	+1-555-0102	2	\N
4	Sarah	Williams	1992-04-18	2022-02-01	58000.00	sarah.williams@company.com	+1-555-0104	4	1
5	James	Brown	1983-09-05	2018-05-12	95000.00	james.brown@company.com	+1-555-0105	5	1
6	Lisa	Miller	1991-12-25	2021-07-30	62000.00	lisa.miller@company.com	+1-555-0106	6	1
8	Jennifer	Wilson	1993-02-28	2023-01-15	54000.00	jennifer.wilson@company.com	+1-555-0108	8	2
9	Michael	Moore	1980-08-10	2017-09-22	105000.00	michael.moore@company.com	+1-555-0109	9	2
13	Daniel	Jackson	1990-03-21	2020-06-25	69000.00	daniel.jackson@company.com	+1-555-0113	13	1
14	Laura	White	1984-07-17	2018-03-14	88000.00	laura.white@company.com	+1-555-0114	14	1
16	Stephanie	Martin	1981-04-30	2016-10-11	92000.00	stephanie.martin@company.com	+1-555-0116	16	2
19	Jason	Clark	1985-12-11	2019-04-05	81000.00	jason.clark@company.com	+1-555-0119	19	1
\.


--
-- TOC entry 4996 (class 0 OID 16907)
-- Dependencies: 232
-- Data for Name: projects; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.projects (project_id, client_id, project_name, project_start_date, project_end_date, project_status, project_budget, project_description) FROM stdin;
1	101	Website Redesign	2024-01-15	2024-06-30	Active	50000.00	Complete redesign of company website with modern UI/UX
2	102	Mobile App Development	2024-02-01	2024-08-15	Active	75000.00	Development of cross-platform mobile application
3	103	CRM Implementation	2023-11-10	2024-03-20	Completed	120000.00	Implementation of new Customer Relationship Management system
4	104	Data Migration	2024-03-01	2024-05-31	In Progress	35000.00	Migration of legacy data to new database system
5	105	E-commerce Platform	2024-01-30	2024-09-30	Active	150000.00	Development of full e-commerce solution
6	101	SEO Optimization	2024-04-01	2024-07-31	Planning	25000.00	Search engine optimization and content strategy
7	106	Cloud Infrastructure	2023-12-01	2024-02-29	Completed	80000.00	Migration to cloud infrastructure and setup
8	107	Payment Gateway	2024-03-15	2024-06-15	Active	45000.00	Integration of new payment processing system
9	108	AI Chatbot	2024-02-20	2024-08-31	Active	95000.00	Development of AI-powered customer service chatbot
10	102	API Development	2024-01-10	2024-04-30	In Progress	60000.00	RESTful API development for third-party integrations
11	109	Security Audit	2024-05-01	2024-05-31	Planning	20000.00	Comprehensive security audit and penetration testing
12	110	Analytics Dashboard	2024-03-10	2024-07-15	Active	55000.00	Real-time analytics and reporting dashboard
13	103	Training Portal	2023-10-01	2024-01-31	Completed	40000.00	Employee training and development portal
14	111	IoT Solution	2024-04-15	2024-10-31	Active	180000.00	Internet of Things monitoring and control system
15	112	Blockchain Prototype	2024-02-01	2024-05-15	In Progress	110000.00	Blockchain technology proof of concept
16	113	Virtual Reality App	2024-03-01	2024-09-30	Active	125000.00	Virtual reality application for product demonstrations
17	114	Disaster Recovery	2024-01-20	2024-03-31	Completed	30000.00	Disaster recovery plan implementation
18	115	Social Media Platform	2024-04-01	2024-12-31	Planning	200000.00	Development of social media networking platform
19	104	Inventory System	2024-02-15	2024-06-30	Active	70000.00	Automated inventory management system
20	116	Machine Learning Model	2024-03-25	2024-08-20	Active	85000.00	Predictive analytics machine learning model
21	200	Base de datos	2025-02-11	2025-03-12	Active	10.00	Hacer una base de datos
\.


--
-- TOC entry 4989 (class 0 OID 16854)
-- Dependencies: 225
-- Data for Name: ref_calendar; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.ref_calendar (day_date, business_day_yn, day_number, period_id, day_name) FROM stdin;
2024-01-15	t	1	202401	Monday
2024-01-16	t	2	202401	Tuesday
2024-01-17	t	3	202401	Wednesday
2024-01-18	t	4	202401	Thursday
2024-01-19	t	5	202401	Friday
2024-01-20	f	6	202401	Saturday
2024-01-21	f	7	202401	Sunday
2024-01-22	t	8	202401	Monday
2024-01-23	t	9	202401	Tuesday
2024-01-24	t	10	202401	Wednesday
2024-01-25	t	11	202401	Thursday
2024-01-26	t	12	202401	Friday
2024-01-27	f	13	202401	Saturday
2024-01-28	f	14	202401	Sunday
2024-01-29	t	15	202401	Monday
2024-01-30	t	16	202401	Tuesday
2024-01-31	t	17	202401	Wednesday
2024-02-01	t	1	202402	Thursday
2024-02-02	t	2	202402	Friday
2024-02-03	f	3	202402	Saturday
\.


--
-- TOC entry 4984 (class 0 OID 16828)
-- Dependencies: 220
-- Data for Name: ref_roles; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.ref_roles (role_code, role_name) FROM stdin;
1	Software Developer
2	Senior Software Developer
3	Project Manager
4	Product Manager
5	DevOps Engineer
6	Data Analyst
7	Data Scientist
8	UX/UI Designer
9	Quality Assurance Engineer
10	Systems Administrator
11	Database Administrator
12	Network Engineer
13	Security Analyst
14	Business Analyst
15	Technical Lead
16	Scrum Master
17	IT Support Specialist
18	Cloud Architect
19	Mobile Developer
20	Frontend Developer
\.


--
-- TOC entry 4986 (class 0 OID 16837)
-- Dependencies: 222
-- Data for Name: ref_skill_levels; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.ref_skill_levels (skill_level_code, skill_level_name, experience_required_years) FROM stdin;
1	Trainee	0
2	Junior	1
3	Junior Advanced	2
4	Intermediate	3
5	Intermediate Plus	4
6	Senior	5
7	Senior Advanced	6
8	Lead	7
9	Senior Lead	8
10	Expert	9
11	Senior Expert	10
12	Principal	11
13	Senior Principal	12
14	Architect	13
15	Senior Architect	14
16	Distinguished Engineer	15
17	Fellow	16
18	Senior Fellow	17
19	Master	18
20	Grand Master	20
\.


--
-- TOC entry 4988 (class 0 OID 16846)
-- Dependencies: 224
-- Data for Name: ref_skills; Type: TABLE DATA; Schema: public; Owner: kevin
--

COPY public.ref_skills (skill_code, skill_name, skill_category) FROM stdin;
1	Java	Programming Languages
2	Python	Programming Languages
3	JavaScript	Programming Languages
4	SQL	Database
5	React	Frontend Development
6	Node.js	Backend Development
7	AWS	Cloud Computing
8	Docker	DevOps
9	Kubernetes	DevOps
10	Git	Development Tools
11	Machine Learning	Data Science
12	Data Analysis	Data Science
13	UI/UX Design	Design
14	Project Management	Management
15	Agile Methodology	Methodologies
16	Cybersecurity	Security
17	Network Configuration	Infrastructure
18	RESTful APIs	Web Development
19	Mobile Development	Mobile Technologies
20	Cloud Architecture	Cloud Computing
\.


--
-- TOC entry 5014 (class 0 OID 0)
-- Dependencies: 226
-- Name: addresses_address_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kevin
--

SELECT pg_catalog.setval('public.addresses_address_id_seq', 23, true);


--
-- TOC entry 5015 (class 0 OID 0)
-- Dependencies: 233
-- Name: employee_on_projects_employee_on_project_period_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kevin
--

SELECT pg_catalog.setval('public.employee_on_projects_employee_on_project_period_id_seq', 100, true);


--
-- TOC entry 5016 (class 0 OID 0)
-- Dependencies: 228
-- Name: employees_employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kevin
--

SELECT pg_catalog.setval('public.employees_employee_id_seq', 85, true);


--
-- TOC entry 5017 (class 0 OID 0)
-- Dependencies: 231
-- Name: projects_project_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kevin
--

SELECT pg_catalog.setval('public.projects_project_id_seq', 21, true);


--
-- TOC entry 5018 (class 0 OID 0)
-- Dependencies: 219
-- Name: ref_roles_role_code_seq; Type: SEQUENCE SET; Schema: public; Owner: kevin
--

SELECT pg_catalog.setval('public.ref_roles_role_code_seq', 20, true);


--
-- TOC entry 5019 (class 0 OID 0)
-- Dependencies: 221
-- Name: ref_skill_levels_skill_level_code_seq; Type: SEQUENCE SET; Schema: public; Owner: kevin
--

SELECT pg_catalog.setval('public.ref_skill_levels_skill_level_code_seq', 20, true);


--
-- TOC entry 5020 (class 0 OID 0)
-- Dependencies: 223
-- Name: ref_skills_skill_code_seq; Type: SEQUENCE SET; Schema: public; Owner: kevin
--

SELECT pg_catalog.setval('public.ref_skills_skill_code_seq', 20, true);


--
-- TOC entry 4813 (class 2606 OID 16870)
-- Name: addresses addresses_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.addresses
    ADD CONSTRAINT addresses_pkey PRIMARY KEY (address_id);


--
-- TOC entry 4819 (class 2606 OID 17083)
-- Name: employee_addresses employee_addresses_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_addresses
    ADD CONSTRAINT employee_addresses_pkey PRIMARY KEY (date_address_from) INCLUDE (employee_id, address_id);


--
-- TOC entry 4823 (class 2606 OID 17005)
-- Name: employee_on_projects employee_on_projects_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_on_projects
    ADD CONSTRAINT employee_on_projects_pkey PRIMARY KEY (employee_on_project_period_id);


--
-- TOC entry 4825 (class 2606 OID 17030)
-- Name: employee_skills employee_skills_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_skills
    ADD CONSTRAINT employee_skills_pkey PRIMARY KEY (employee_id, skill_code);


--
-- TOC entry 4815 (class 2606 OID 16882)
-- Name: employees employees_email_key; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_email_key UNIQUE (email);


--
-- TOC entry 4817 (class 2606 OID 16880)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 4821 (class 2606 OID 16916)
-- Name: projects projects_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (project_id);


--
-- TOC entry 4811 (class 2606 OID 16859)
-- Name: ref_calendar ref_calendar_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.ref_calendar
    ADD CONSTRAINT ref_calendar_pkey PRIMARY KEY (day_date);


--
-- TOC entry 4805 (class 2606 OID 16835)
-- Name: ref_roles ref_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.ref_roles
    ADD CONSTRAINT ref_roles_pkey PRIMARY KEY (role_code);


--
-- TOC entry 4807 (class 2606 OID 16844)
-- Name: ref_skill_levels ref_skill_levels_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.ref_skill_levels
    ADD CONSTRAINT ref_skill_levels_pkey PRIMARY KEY (skill_level_code);


--
-- TOC entry 4809 (class 2606 OID 16853)
-- Name: ref_skills ref_skills_pkey; Type: CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.ref_skills
    ADD CONSTRAINT ref_skills_pkey PRIMARY KEY (skill_code);


--
-- TOC entry 4828 (class 2606 OID 16976)
-- Name: employee_addresses address_id; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_addresses
    ADD CONSTRAINT address_id FOREIGN KEY (address_id) REFERENCES public.addresses(address_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 4829 (class 2606 OID 16971)
-- Name: employee_addresses employee_id; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_addresses
    ADD CONSTRAINT employee_id FOREIGN KEY (employee_id) REFERENCES public.employees(employee_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- TOC entry 4833 (class 2606 OID 17031)
-- Name: employee_skills employee_skills_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_skills
    ADD CONSTRAINT employee_skills_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES public.employees(employee_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 4834 (class 2606 OID 17036)
-- Name: employee_skills employee_skills_skill_code_fkey; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_skills
    ADD CONSTRAINT employee_skills_skill_code_fkey FOREIGN KEY (skill_code) REFERENCES public.ref_skills(skill_code) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 4835 (class 2606 OID 17041)
-- Name: employee_skills employee_skills_skill_level_code_fkey; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_skills
    ADD CONSTRAINT employee_skills_skill_level_code_fkey FOREIGN KEY (skill_level_code) REFERENCES public.ref_skill_levels(skill_level_code) ON UPDATE CASCADE ON DELETE SET NULL;


--
-- TOC entry 4826 (class 2606 OID 17046)
-- Name: employees employees_role_code_fkey; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_role_code_fkey FOREIGN KEY (role_code) REFERENCES public.ref_roles(role_code) ON UPDATE CASCADE ON DELETE SET NULL NOT VALID;


--
-- TOC entry 4830 (class 2606 OID 17063)
-- Name: employee_on_projects from_day_date; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_on_projects
    ADD CONSTRAINT from_day_date FOREIGN KEY (from_day_date) REFERENCES public.ref_calendar(day_date) ON UPDATE CASCADE ON DELETE SET DEFAULT NOT VALID;


--
-- TOC entry 4831 (class 2606 OID 17058)
-- Name: employee_on_projects project_id; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_on_projects
    ADD CONSTRAINT project_id FOREIGN KEY (project_id) REFERENCES public.projects(project_id) ON UPDATE CASCADE ON DELETE SET NULL NOT VALID;


--
-- TOC entry 4827 (class 2606 OID 17073)
-- Name: employees supervisor_id; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT supervisor_id FOREIGN KEY (supervisor_id) REFERENCES public.employees(employee_id) ON UPDATE CASCADE ON DELETE SET NULL NOT VALID;


--
-- TOC entry 4832 (class 2606 OID 17068)
-- Name: employee_on_projects to_day_date; Type: FK CONSTRAINT; Schema: public; Owner: kevin
--

ALTER TABLE ONLY public.employee_on_projects
    ADD CONSTRAINT to_day_date FOREIGN KEY (to_day_date) REFERENCES public.ref_calendar(day_date) ON UPDATE CASCADE ON DELETE SET NULL NOT VALID;


-- Completed on 2025-11-21 15:57:32

--
-- PostgreSQL database dump complete
--

\unrestrict luTagFXpEBX8fs3A7hz3tXoKNpSVd8vY6W7dcLAaJU4HYfx11yNfVj8KGWqdznr

